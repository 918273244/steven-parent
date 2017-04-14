package com.steven.gantt.service;

import com.steven.gantt.entity.User;

/**
 * Created by Steven on 2017/4/13.
 */
public interface UserService {
    public User loadUserByUsername(String userName) throws Exception;
}
