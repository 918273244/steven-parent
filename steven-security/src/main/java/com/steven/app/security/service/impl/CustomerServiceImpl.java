package com.steven.app.security.service.impl;

import com.steven.common.dao.UserDao;
import com.steven.app.security.service.UserService;
import com.steven.common.entity.CurrentUser;
import com.steven.common.entity.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven on 2017/4/17.
 */
@Service
public class CustomerServiceImpl implements UserService,  UserDetailsService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserByName(String userName) {
        return userDao.findByUsername(userName);
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
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userInfo.getRole()));
        System.out.println("角色"+userInfo.getUsername()+": "+userInfo.getUserpassword());

      /*  return new org.springframework.security.core.userdetails.User(userInfo.getUsername(),
                userInfo.getUserpassword(),
                true,//是否可用
                true,//是否过期
                true,//证书不过期为true
                true,//账户未锁定为true
                authorities);*/
      return new CurrentUser(userInfo);

    }
}
