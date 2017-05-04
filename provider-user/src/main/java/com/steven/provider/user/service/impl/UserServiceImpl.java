package com.steven.provider.user.service.impl;

import com.steven.provider.user.dao.UserDao;
import com.steven.provider.user.entity.User;
import com.steven.provider.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Steven on 2017/4/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public int saveUser(String username, String password, String role) {
        return userDao.saveUser(username, password, role);
    }
}
