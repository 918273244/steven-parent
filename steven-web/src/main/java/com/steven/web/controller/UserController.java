package com.steven.web.controller;

import com.steven.web.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Steven on 2017/4/17.
 */
@Controller
@RequestMapping("/registerUser")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/reg")
    public String register(){
        return "register";
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public int saveUser(String username, String password){

        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);//将密码加密 可以先设置初始密码：
        String psd = bc.encode(password);
        System.out.println(psd);
      return   userService.saveUser(username,psd,"ROLE_USER");
    }

}
