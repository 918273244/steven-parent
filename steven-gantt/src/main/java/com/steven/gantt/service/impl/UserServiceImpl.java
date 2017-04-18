package com.steven.gantt.service.impl;

import com.steven.gantt.dao.UserDao;
import com.steven.gantt.entity.User;
import com.steven.gantt.service.UserService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Steven on 2017/4/17.
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userInfo = userDao.findByUsername(username);
        if(userInfo == null){
            throw new UsernameNotFoundException("userInfo is null");
        }

        //根据用户获取用户角色
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(userInfo.getRole()));
        System.out.println("角色"+userInfo.getUsername()+": "+userInfo.getUserpassword());
        return new org.springframework.security.core.userdetails.User(userInfo.getUsername(),
                userInfo.getUserpassword(),
                true,//是否可用
                true,//是否过期
                true,//证书不过期为true
                true,//账户未锁定为true
                AuthorityUtils.createAuthorityList(userInfo.getRole()));
    }
}
