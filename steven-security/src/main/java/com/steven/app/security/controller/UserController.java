package com.steven.app.security.controller;

import com.steven.app.security.service.UserService;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Steven on 2017/4/17.
 */
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/registerView")
    public String register(){
        return "user/register";
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public int saveUser(String username, String password){
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        password = md5.encodePassword(username, password);
        return userService.saveUser(username,password,"ROLE_USER");
    }


    public static void main(String[] args) {
        Md5PasswordEncoder md5 = new Md5PasswordEncoder();
        System.out.println( md5.encodePassword("www", "www"));
    }
}
