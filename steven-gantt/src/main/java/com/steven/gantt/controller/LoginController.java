package com.steven.gantt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Steven on 2017/4/16.
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
     @RequestMapping("/homepage")
    public String homepage(){
        return "homepage";
    }


}
