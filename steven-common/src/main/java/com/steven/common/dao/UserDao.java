package com.steven.common.dao;


import com.steven.common.entity.User;

/**
 * Created by Steven on 2017/4/16.
 */
public interface UserDao {
    public User findByUsername(String username);

    public int saveUser(String username, String password, String role);
}
