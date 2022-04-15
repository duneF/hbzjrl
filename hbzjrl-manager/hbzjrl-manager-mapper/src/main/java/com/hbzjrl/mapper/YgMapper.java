package com.hbzjrl.mapper;

import com.hbzjrl.pojo.YgPojo;

import javax.management.Query;
import java.util.List;
import java.util.Map;

/***
 *@Author: Yc
 *@Date:2022/4/12 11:59
 *@Description:
 */
public interface YgMapper {
    List<YgPojo> findAllByYgTable(Map<String,Integer> map);

    Integer count();

    YgPojo ygUpdateFindById(Integer tiQuId);
}
