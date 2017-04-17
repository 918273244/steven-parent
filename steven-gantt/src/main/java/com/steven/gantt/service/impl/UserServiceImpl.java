package com.steven.gantt.service.impl;

import com.steven.gantt.dao.UserDao;
import com.steven.gantt.entity.SecurityUser;
import com.steven.gantt.entity.User;
import com.steven.gantt.service.UserService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * UserServiceImpl
 * Created by Steven on 2017/4/13.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;


    public User getUserByName(String userName) {
        return userDao.findByUsername(userName);
    }

    @Override
    public int saveUser(String username, String password, String role) {
        return userDao.saveUser(username, password, role);
    }
/*

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = userDao.findByUsername(username);
        if(userInfo == null){
            throw new UsernameNotFoundException("userInfo is null");
        }
        //根据用户获取用户角色
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userInfo.getRole()));
        System.out.println("角色"+userInfo.getUserName()+": "+userInfo.getUserPassword());

        return new org.springframework.security.core.userdetails.User(userInfo.getUserName(),
                userInfo.getUserPassword(),
                true,//是否可用
                true,//是否过期
                true,//证书不过期为true
                true,//账户未锁定为true
                 authorities);


        // SecurityUser实现UserDetails并将SysUser的name映射为username
//        SecurityUser seu = new SecurityUser(userInfo);
//        return  seu;
    }
*/


}
