package com.steven.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Steven on 2017/4/17.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/hello")
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String hello(){
        return "helloword";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
