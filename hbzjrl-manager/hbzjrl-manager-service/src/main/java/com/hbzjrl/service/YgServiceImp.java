package com.hbzjrl.service;

import com.github.pagehelper.PageHelper;
import com.google.gson.Gson;
import com.hbzjrl.common.utils.FtpUtil;
import com.hbzjrl.common.utils.IDCardOCR;
import com.hbzjrl.common.utils.shenFenZhengGetAgeGender;
import com.hbzjrl.mapper.YgMapper;
import com.hbzjrl.pojo.ImageOCRPojo;
import com.hbzjrl.pojo.YgPojo;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *Author: Yc
 *Date:2022/4/14 12:48
 *Description:
 */
@Service
public class YgServiceImp implements YgService {
    @Autowired
    YgMapper ygMapper;
    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public List<YgPojo> findAllByYgTable(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Integer> map = new HashMap<>();
        map.put("pageNum", (pageNum - 1) * pageSize);
        map.put("pageSize", pageSize);

        return ygMapper.findAllByYgTable(map);
    }

    @Override
    public Integer count() {
        return ygMapper.count();
    }

    @Override
    public YgPojo ygUpdateFindById(Integer tiQuId) {
        return ygMapper.ygUpdateFindById(tiQuId);
    }

    @Override
    public void ygUpdateIng(YgPojo ygPojo) {
        ygMapper.ygUpdateIng(ygPojo);
    }

    @Override
    public void deleteById(Integer id) {
        ygMapper.deleteById(id);
    }

    @Override
    public Integer countByWhereHome(String whereHome) {
        whereHome = "%" + whereHome + "%";
        return ygMapper.countByWhereHome(whereHome);
    }

    @Override

    public List<YgPojo> ygFindByQuDao(String whereHome) {

        Map<String, Object> map = new HashMap<>();
        whereHome = "%" + whereHome + "%";
        map.put("whereHome", whereHome);
        return ygMapper.ygFindByQuDao(map);
    }

    @Override
    public Integer countByName(String name) {
        name = "%" + name + "%";
        return ygMapper.countByName(name);
    }

    @Override
    public List<YgPojo> ygFIndByName(String name) {
        Map<String, Object> map = new HashMap<>();
        name = "%" + name + "%";
        map.put("name", name);
        return ygMapper.ygFIndByName(map);
    }

    @Override
    public Integer conuntByPhone(String phoneToString) {
        phoneToString = "%" + phoneToString + "%";
        return ygMapper.conuntByPhone(phoneToString);
    }

    @Override
    public List<YgPojo> ygFIndByPhone(String phone) {
        Map<String, Object> map = new HashMap<>();
        phone = "%" + phone + "%";
        map.put("phone", phone);
        return ygMapper.ygFIndByPhone(map);
    }

    @Override
    public Integer countByAddress(String address) {
        address = "%" + address + "%";
        return ygMapper.countByAddress(address);
    }

    @Override
    public List<YgPojo> ygFIndByAddress(String address) {
        Map<String, Object> map = new HashMap<>();
        address = "%" + address + "%";
        map.put("address", address);
        return ygMapper.ygFIndByAddress(map);
    }

    @Override
    public Integer countByQiYe(String factory) {
        factory = "%" + factory + "%";
        return ygMapper.countByQiYe(factory);
    }

    @Override
    public List<YgPojo> ygFindByQiYe(String factory) {
        Map<String, Object> map = new HashMap<>();
        factory = "%" + factory + "%";
        map.put("factory", factory);
        return ygMapper.ygFindByQiYe(map);
    }

    @Override
    public void addYgShouDong(YgPojo ygPojo) {
        shenFenZhengGetAgeGender ageGender = new shenFenZhengGetAgeGender();
        String genderGet = ageGender.judgeGender(ygPojo.getSfNumber().toString());
        int ageGet = ageGender.countAge(ygPojo.getSfNumber().toString());
        ygPojo.setAge(ageGet);
        ygPojo.setSex(genderGet);
        ygMapper.addYgShouDong(ygPojo);
    }

    @Override
    public void addYgTuPian(YgPojo ygPojo, MultipartFile file) throws IOException {
       InputStream inp= file.getInputStream();
        //获取文件名
        String filename = file.getOriginalFilename();
        //获取文件的后缀名
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //使用当前日期加毫秒值重新生成名字
        DateTime dateTime = new DateTime();
        int year = dateTime.getYear();
        int monthOfYear = dateTime.getMonthOfYear();
        int dayOfMonth = dateTime.getDayOfMonth();
        long millis = System.currentTimeMillis();//按当前毫秒生成
        //新名字为newImageName
        String newImageName = "" + year + monthOfYear + dayOfMonth + millis + suffixName;
        //等待优化
        //先把磁盘固定文件夹写死,再加图片Old名字传给上传util的new file参数
        String urlInPut = "\\E:\\image\\" + filename;
        //生成的日期加上"/"用作ftp服务器按日期排列的路径
        String filePath = year + "/" + monthOfYear + "/" + dayOfMonth;
        try {
            //读入本地电脑路径
            FileInputStream in = new FileInputStream(new File(urlInPut));

            //调用封装ftpUtil上传工具
            FtpUtil ftpUtil = new FtpUtil();
            //调用上传工具上传方法,读取properties文件引入的参数@Value("${FTP_ADDRESS}") private String FTP_ADDRESS;
            ftpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, newImageName, inp);
            //拼接公网图片路径等待传入OCR识别
            String ORCURL = IMAGE_BASE_URL + filePath + "/" + newImageName;
            //创建OCR对象
            IDCardOCR idCardOCR = new IDCardOCR();
            //传入公网url,返回json字符串
            String imageJson = idCardOCR.imageOCR(ORCURL);
            //解析json
            Gson gson = new Gson();
            //创建接收json字符串的bean
            ImageOCRPojo imageOCRPojo = new ImageOCRPojo();
            //赋值给jsonBean
            imageOCRPojo=gson.fromJson(imageJson,imageOCRPojo.getClass());
            //通过身份证识别年龄
            shenFenZhengGetAgeGender ageGender = new shenFenZhengGetAgeGender();
            int ageGet = ageGender.countAge(imageOCRPojo.getIdNum());
            //给员工pojo添加赋值字段
            ygPojo.setAge(ageGet);
            ygPojo.setName(imageOCRPojo.getName());
            ygPojo.setSex(imageOCRPojo.getSex());
            ygPojo.setAddress(imageOCRPojo.getAddress());
            ygPojo.setSfNumber(new BigInteger(imageOCRPojo.getIdNum()));
            //向ygMapper传参
            ygMapper.addYgTuPian(ygPojo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
