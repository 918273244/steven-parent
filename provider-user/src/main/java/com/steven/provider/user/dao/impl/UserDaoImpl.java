package com.steven.provider.user.dao.impl;

import com.steven.provider.user.dao.UserDao;
import com.steven.provider.user.entity.User;
import com.steven.provider.user.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * dao
 * Created by Steven on 2017/4/16.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private UserMapper userMapper;
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public int saveUser(String username, String password, String role) {
        return userMapper.saveUser(username, password, role);
    }
}
