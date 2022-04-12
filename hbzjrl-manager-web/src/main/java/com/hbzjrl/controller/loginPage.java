package com.hbzjrl.controller;

import com.hbzjrl.pojo.SSOT;
import com.hbzjrl.pojo.UserDengLu;
import com.hbzjrl.service.loginService;
import org.apache.http.HttpRequest;
import org.noggit.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Response;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/***
 *@Author: Yc
 *@Date:2022/4/613:43
 *@Description:
 */
@Controller
@RequestMapping(value = "/user")
public class loginPage {

    @Autowired
    private loginService loginService;
    private String username;
    private String password;
    private SSOT ssot;
    private HashMap<String, String> map;

    @RequestMapping(value = "/login")
    @ResponseBody
    public HashMap<String, String> login(UserDengLu userDengLu,HttpServletResponse resp) throws IOException {
        ssot = new SSOT ();
        map = new HashMap<> ();
        username = userDengLu.getUsername();
        password = userDengLu.getPassword();
        map.put("username",username);
        map.put("password", password);
        userDengLu  = loginService.findUserByNameAndPasswd(map);

        if (userDengLu!=null){
            map.put("redirect","/show/ygShowAll");
            System.out.println("map准备重定向到findALlYg");
            ModelAndView mv=new ModelAndView("redirect:/show/ygShowAll");
            resp.sendRedirect("/show/ygShowAll");
            return map;
        }
        map.put("msg","账号密码错误");
        return map;
    }
}
