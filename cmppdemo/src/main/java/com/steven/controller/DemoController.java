package com.steven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: Steven 孙
 * @Date: 2019/10/24 13:50
 * @Description:
 */
@Controller
@RequestMapping("demo")
public class DemoController {


    @RequestMapping("say")
    @ResponseBody
    public String say(){
        return "hello word";
    }

}
