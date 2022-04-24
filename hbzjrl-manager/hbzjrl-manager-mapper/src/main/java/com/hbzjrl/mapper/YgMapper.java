package com.hbzjrl.mapper;

import com.hbzjrl.pojo.YgPojo;

import java.util.List;
import java.util.Map;

/***
 *@Author: Yc
 *@Date:2022/4/12 11:59
 *@Description:
 */
public interface YgMapper {
    //查询所有
    List<YgPojo> findAllByYgTable(Map<String,Integer> map);
    //查询所有总条数
    Integer count();
    //根据ID查找
    YgPojo ygUpdateFindById(Integer tiQuId);
    //根据ID更新数据
    void ygUpdateIng(YgPojo ygPojo);
    //根据ID删除数据
    void deleteById(Integer id);
    //根据渠道查询数据
    List<YgPojo> ygFindByQuDao(Map<String, Object> map);
    //根据姓名查询数据
    List<YgPojo> ygFIndByName(Map<String, Object> map);
    //根据手机查询数据
    List<YgPojo> ygFIndByPhone(Map<String, Object> map);
    //根据地址查询数据
    List<YgPojo> ygFIndByAddress(Map<String, Object> map);
    //根据企业查询数据
    List<YgPojo> ygFindByQiYe(Map<String, Object> map);
    //根据渠道查询总条数
    Integer countByWhereHome(String whereHome);
    //根据姓名查询总条数
    Integer countByName(String name);
    //根据手机查询总条数
    Integer conuntByPhone(String phoneToString);
    //根据地址查询总条数
    Integer countByAddress(String address);
    //根据企业查询总条数
    Integer countByQiYe(String factory);
}
