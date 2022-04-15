package com.hbzjrl.mapper;

import com.hbzjrl.pojo.UserDengLu;

import java.util.HashMap;

/***
 *@Author: Yc
 *@Date:2022/4/11 21:16
 *@Description:
 */
public interface LoginMapper {

    UserDengLu findUserByNameAndPasswd(HashMap<String, String> map);
}

