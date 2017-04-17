package com.steven.gantt.entity;


/**
 * Created by Steven on 2017/4/17.
 */
public class SecurityUser extends User  {


    public SecurityUser(User user){
       if (user != null){
           this.setUserName(user.getUserName());
           this.setUserPassword(user.getUserPassword());
           this.setRole(user.getRole());
       }
    }
}
