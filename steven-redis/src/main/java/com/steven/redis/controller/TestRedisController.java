package com.steven.redis.controller;

import com.steven.redis.dao.CommonRedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Steven on 2017/5/17.
 */
@RestController
public class TestRedisController {

    @Autowired
    CommonRedisDao dao;

    @GetMapping("/get/{key}")
    public String find(@PathVariable("key") String key) {
        String value = dao.getValue(key);
        return value;
    }

    @GetMapping("/add/{key}/{value}")
    public Boolean add(@PathVariable("value") String value, @PathVariable("key") String key) {
        return dao.cacheValue(key, value);
    }

    @GetMapping("/del/{key}")
    public Boolean del(@PathVariable("key") String key) {
        return dao.removeValue(key);
    }

    @GetMapping("/count/{key}")
    public Long count(@PathVariable("key") String key) {
        return dao.getListSize(key);
    }

}
