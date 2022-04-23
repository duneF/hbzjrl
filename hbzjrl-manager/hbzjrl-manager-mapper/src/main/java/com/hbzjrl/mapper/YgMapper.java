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
    //查询总条数
    Integer count();
    //根据ID查找
    YgPojo ygUpdateFindById(Integer tiQuId);
    //根据ID更新数据
    void ygUpdateIng(YgPojo ygPojo);
    //根据ID删除数据
    void deleteById(Integer id);
    //根据渠道查询数据
    List<YgPojo> ygFindByQuDao(Map<String, Object> map);

    List<YgPojo> ygFIndByName(Map<String, Object> map);

    List<YgPojo> ygFIndByPhone(Map<String, Object> map);

    List<YgPojo> ygFIndByAddress(Map<String, Object> map);

    List<YgPojo> ygFindByQiYe(Map<String, Object> map);

    Integer countByWhereHome(String whereHome);
}
