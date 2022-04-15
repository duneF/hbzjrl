package com.hbzjrl.service;

import com.hbzjrl.mapper.LoginMapper;
import com.hbzjrl.pojo.UserDengLu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/***
 *@Author: Yc
 *@Date:2022/4/11 17:31
 *@Description:
 */
@Service
public class loginService {
    @Autowired
    private LoginMapper loginMapper;
    private UserDengLu userDengLu;

    public UserDengLu findUserByNameAndPasswd(HashMap<String, String> map) {
        userDengLu = loginMapper.findUserByNameAndPasswd(map);
        return userDengLu;
    }
}
