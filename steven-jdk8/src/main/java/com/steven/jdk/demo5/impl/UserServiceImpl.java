package com.steven.jdk.demo5.impl;

import com.steven.jdk.demo5.IUser;
import com.steven.jdk.demo5.IUserService;
import com.steven.jdk.demo5.User;

/**
 * Created by Steven on 2017/5/25.
 */
public class UserServiceImpl implements IUserService {
    @Override
    public void save(IUser user) {
        User s = (User) user;
        ((User) user).setName("sadasda");
    }
}
