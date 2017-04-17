package com.steven.gantt.dao.impl;

import com.steven.gantt.dao.UserDao;
import com.steven.gantt.entity.User;
import com.steven.gantt.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * dao
 * Created by Steven on 2017/4/16.
 */
@Repository
public class UserDaoImpl implements UserDao{
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
