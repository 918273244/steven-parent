package com.steven.gantt.service.impl;

import com.steven.gantt.entity.User;
import com.steven.gantt.service.UserService;

/**
 * Created by Steven on 2017/4/13.
 */
public class UserServiceImpl implements UserService {


    @Override
    public User loadUserByUsername(String userName) throws Exception {
        User userInfo = getUserByName(userName);
        if(userInfo == null){
            throw new Exception("userInfo is null");
        }

        //根据用户获取用户角色

        return null;
    }

    public User getUserByName(String userName) {
        return null;
    }

}
