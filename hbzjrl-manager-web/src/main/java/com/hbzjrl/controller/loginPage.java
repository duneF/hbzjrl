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

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

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
    public HashMap<String, String> login(UserDengLu userDengLu) {
        ssot = new SSOT ();
        map = new HashMap<> ();
        username = userDengLu.getUsername();
        password = userDengLu.getPassword();
        System.out.println("CtrollerAAAAAAA"+userDengLu.getUsername()+userDengLu.getPassword());
        map.put("username",username);
        map.put("password", password);
        userDengLu  = loginService.findUserByNameAndPasswd(map);
        System.out.println("CtrollerBBBBBB"+userDengLu.toString());
        if (userDengLu!=null){
            System.out.println("CtrollerCCCCCCC"+userDengLu.toString());
            ssot.setStatus(200);
            System.out.println("Ctrollerddd"+userDengLu.toString());
            map.put("status","200");
            map.put("redirect","/show");
        }
        map.put("msg","账号密码错误");
        return map;
    }
}
