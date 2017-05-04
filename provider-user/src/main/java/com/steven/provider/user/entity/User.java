package com.steven.provider.user.entity;

import java.io.Serializable;

/**
 * user实体类
 * Created by Steven on 2017/5/3.
 */
public class User implements Serializable{
    private long id;
    private String username;
    private String userpassword;
    private String role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return userpassword;
    }

    public void setPassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
