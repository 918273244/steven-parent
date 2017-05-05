package com.steven.movie.feign.controller;

import com.steven.movie.feign.dao.UserFeignClient;
import com.steven.movie.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Steven on 2017/5/5.
 */
@RestController
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/feign/{name}")
    public User getUserByName(@PathVariable String name){
        User user  = userFeignClient.getUserByNames(name);
        return user;
    }


    @GetMapping("/feign/userList")
    public List<User> userList(){
        List<User> list = userFeignClient.userList();
        return list;
    }

    @GetMapping("/feign/saveUser")
    public String saveUser(@RequestParam("username")String username, @RequestParam("password") String password){
       return userFeignClient.saveUser(username, password);
    }
}
