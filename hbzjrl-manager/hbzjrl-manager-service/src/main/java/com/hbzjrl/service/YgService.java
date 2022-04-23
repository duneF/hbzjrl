package com.hbzjrl.service;

import com.github.pagehelper.PageInfo;
import com.hbzjrl.mapper.YgMapper;
import com.hbzjrl.pojo.YgPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

/***
 *@Author: Yc
 *@Date:2022/4/12 11:36
 *@Description:
 */
public interface YgService {

    List<YgPojo> findAllByYgTable(Integer pageNum, Integer pageSize);

    Integer count();

    YgPojo ygUpdateFindById(Integer tiQuId);

    void ygUpdateIng(YgPojo ygPojo);

    void deleteById(Integer id);

    Integer countByWhereHome(String whereHome);

    List<YgPojo> ygFindByQuDao(String whereHome);

    List<YgPojo> ygFIndByName(String name, Integer pageNum, Integer pageSize);

    List<YgPojo> ygFIndByPhone(String phone, Integer pageNum, Integer pageSize);

    List<YgPojo> ygFIndByAddress(String address, Integer pageNum, Integer pageSize);

    List<YgPojo> ygFindByQiYe(String factory, Integer pageNum, Integer pageSize);


}
