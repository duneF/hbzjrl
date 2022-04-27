package com.hbzjrl.service;

import com.github.pagehelper.PageHelper;
import com.hbzjrl.common.utils.shenFenZhengGetAgeGender;
import com.hbzjrl.mapper.YgMapper;
import com.hbzjrl.pojo.YgPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<YgPojo> findAllByYgTable( Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Integer> map = new HashMap<>();
        map.put("pageNum",(pageNum-1)*pageSize);
        map.put("pageSize",pageSize);

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
        System.out.println("进入service Imp");
        System.out.println(ygPojo.toString());

        ygMapper.ygUpdateIng(ygPojo);
    }

    @Override
    public void deleteById(Integer id) {
        System.out.println("进入deleteByID ServiceImp");
        ygMapper.deleteById(id);
    }

    @Override
    public Integer countByWhereHome(String whereHome) {
        whereHome="%"+whereHome+"%";
        return ygMapper.countByWhereHome(whereHome);
    }
    @Override

    public List<YgPojo> ygFindByQuDao(String whereHome) {

        Map<String, Object> map = new HashMap<>();
        whereHome="%"+whereHome+"%";
        map.put("whereHome",whereHome);
        return  ygMapper.ygFindByQuDao(map);
    }

    @Override
    public Integer countByName(String name) {
        name="%"+name+"%";
        return ygMapper.countByName(name);
    }

    @Override
    public List<YgPojo> ygFIndByName(String name) {
        System.out.println("进入按姓名Service"+name);
        Map<String, Object> map = new HashMap<>();
        name="%"+name+"%";
        map.put("name",name);
        return ygMapper.ygFIndByName(map);
    }

    @Override
    public Integer conuntByPhone(String phoneToString) {
        phoneToString="%"+phoneToString+"%";
        return ygMapper.conuntByPhone(phoneToString);
    }

    @Override
    public List<YgPojo> ygFIndByPhone(String phone) {
        System.out.println("进入按手机Service"+phone);
        Map<String, Object> map = new HashMap<>();
        phone="%"+phone+"%";
        map.put("phone",phone);
        return ygMapper.ygFIndByPhone(map);
    }

    @Override
    public Integer countByAddress(String address) {
        address="%"+address+"%";
        return ygMapper.countByAddress(address);
    }

    @Override
    public List<YgPojo> ygFIndByAddress(String address) {
        System.out.println("进入按地址Service"+address);
        Map<String, Object> map = new HashMap<>();
        address="%"+address+"%";
        map.put("address",address);
        return  ygMapper.ygFIndByAddress(map);
    }

    @Override
    public Integer countByQiYe(String factory) {
        factory="%"+factory+"%";
        return ygMapper.countByQiYe(factory);
    }

    @Override
    public List<YgPojo> ygFindByQiYe(String factory) {
        System.out.println("进入按企业Service"+factory);
        Map<String, Object> map = new HashMap<>();
        factory="%"+factory+"%";
        map.put("factory",factory);
        return ygMapper.ygFindByQiYe(map);
    }
    @Override
    public void addYgShouDong(YgPojo ygPojo) {
        shenFenZhengGetAgeGender ageGender = new shenFenZhengGetAgeGender();
        String genderGet = ageGender.judgeGender(ygPojo.getSfNumber().toString());
        int ageGet = ageGender.countAge(ygPojo.getSfNumber().toString());
        System.out.println("获取的年龄为"+genderGet+ageGet);
    }

}
