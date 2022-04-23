package com.hbzjrl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hbzjrl.mapper.YgMapper;
import com.hbzjrl.pojo.YgPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 *@Author: Yc
 *@Date:2022/4/14 12:48
 *@Description:
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

        List<YgPojo> list = ygMapper.findAllByYgTable(map);

        return list;
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

}
