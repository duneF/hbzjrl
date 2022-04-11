package com.hbzjrl.controller;

import com.hbzjrl.pojo.UserDengLu;
import org.apache.http.HttpRequest;
import org.noggit.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/***
 *@Author: Yc
 *@Date:2022/4/613:43
 *@Description:
 */
@Controller
@RequestMapping(value = "/user")
public class loginPage {


    @RequestMapping(value = "/login")
    @ResponseBody
    public void login(UserDengLu userDengLu) {

    }
}
