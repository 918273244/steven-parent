package com.steven.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * security安全拦截
 * Created by Steven on 2017/4/13.
 */
@Controller
public class TestServerController {

    @RequestMapping("/home")
    public String helloword(){
        System.out.println("new");
        return "helloword";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return "helloword";
    }
}
