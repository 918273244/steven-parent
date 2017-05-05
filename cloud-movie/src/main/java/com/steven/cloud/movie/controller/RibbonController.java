package com.steven.cloud.movie.controller;

import com.steven.cloud.movie.entity.User;
import com.steven.cloud.movie.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Steven on 2017/5/5.
 */
@RestController
public class RibbonController {

    @Autowired
    private RibbonService ribbonService;

    @RequestMapping("/robbin/{name}")
    public User getUser(@PathVariable String name){
       return ribbonService.findByName(name);
    }

}
