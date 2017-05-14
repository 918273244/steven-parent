package com.steven.netty.demo.bo;


import com.steven.netty.demo.entity.User;
import com.steven.netty.nettyrest.response.Info;

/**
 * Created by zhoumengkang on 5/1/16.
 */
public class UserInfo extends Info {
    private User user;

    public User getUser() {
        return user;
    }

    public UserInfo(User user) {
        this.user = user;
    }
}