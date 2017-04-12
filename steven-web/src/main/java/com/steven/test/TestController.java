package com.steven.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Steven on 2017/4/12.
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "web start...";
    }

}
