package com.steven.jdk.demo5;

/**
 * Created by Steven on 2017/5/25.
 */
public class UserController {

    private IUserService userService;


    public String addUser(){
        User user = new User();
        userService.save(user);
        return "";
    }
}
