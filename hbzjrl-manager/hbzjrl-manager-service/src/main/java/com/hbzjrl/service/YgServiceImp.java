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

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigInteger;
import java.net.URI;
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
    public void addYgTuPian(YgPojo ygPojo, MultipartFile file,HttpServletRequest request) throws IOException {
       InputStream inp= file.getInputStream();
        //???????????????
        String filename = file.getOriginalFilename();
        //????????????????????????
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //????????????????????????????????????????????????
        DateTime dateTime = new DateTime();
        int year = dateTime.getYear();
        int monthOfYear = dateTime.getMonthOfYear();
        int dayOfMonth = dateTime.getDayOfMonth();
        long millis = System.currentTimeMillis();//?????????????????????
        //????????????newImageName
        String newImageName = "" + year + monthOfYear + dayOfMonth + millis + suffixName;
        //????????????
        //?????????????????????????????????,????????????Old??????????????????util???new file??????

        String urlInPut = "\\E:\\image\\" + filename;
        //?????????????????????"/"??????ftp?????????????????????????????????
        String filePath = year + "/" + monthOfYear + "/" + dayOfMonth;
        String realPath1 = request.getServletContext().getRealPath("/");

        System.out.println("??????try??????"+filePath);


        try {
            //????????????????????????
            FileInputStream in = new FileInputStream(new File(realPath1,filename));
            System.out.println("??????try ??????new File in");

            //????????????ftpUtil????????????
            FtpUtil ftpUtil = new FtpUtil();
            //??????????????????????????????,??????properties?????????????????????@Value("${FTP_ADDRESS}") private String FTP_ADDRESS;
            ftpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, filePath, newImageName, in);
            //????????????????????????????????????OCR??????
            String ORCURL = IMAGE_BASE_URL + filePath + "/" + newImageName;
            //??????OCR??????
            IDCardOCR idCardOCR = new IDCardOCR();
            //????????????url,??????json?????????
            String imageJson = idCardOCR.imageOCR(ORCURL);
            //??????json
            Gson gson = new Gson();
            //????????????json????????????bean
            ImageOCRPojo imageOCRPojo = new ImageOCRPojo();
            //?????????jsonBean
            imageOCRPojo=gson.fromJson(imageJson,imageOCRPojo.getClass());
            //???????????????????????????
            shenFenZhengGetAgeGender ageGender = new shenFenZhengGetAgeGender();
            int ageGet = ageGender.countAge(imageOCRPojo.getIdNum());
            //?????????pojo??????????????????
            ygPojo.setAge(ageGet);
            ygPojo.setName(imageOCRPojo.getName());
            ygPojo.setSex(imageOCRPojo.getSex());
            ygPojo.setAddress(imageOCRPojo.getAddress());
            ygPojo.setSfNumber(new BigInteger(imageOCRPojo.getIdNum()));
            //???ygMapper??????
            ygMapper.addYgTuPian(ygPojo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
