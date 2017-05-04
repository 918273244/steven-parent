package com.steven.provider.user.controller;

import com.steven.provider.user.entity.User;
import com.steven.provider.user.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Steven on 2017/5/3.
 */
@RestController
public class UserController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserService userService;

    @GetMapping("/{name}")
    public User getUserByName(@PathVariable String name){
        User user = userService.findByUsername(name);
        return user;
    }

    @GetMapping("/saveUser")
    public String saveUser(String username, String password){
        BCryptPasswordEncoder bc=new BCryptPasswordEncoder(4);//将密码加密 可以先设置初始密码：
        String psd = bc.encode(password);
        userService.saveUser(username, psd,"ROLE_USER");
        return "success";
    }



    @GetMapping("/instance-info")
    public ServiceInstance showInfo(){
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }
}
