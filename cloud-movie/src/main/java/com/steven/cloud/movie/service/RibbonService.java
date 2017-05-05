package com.steven.cloud.movie.service;

import com.steven.cloud.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Steven on 2017/5/5.
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    public User findByName(String name){
        // http://服务提供者的serviceId/url
        return this.restTemplate.getForObject("http://provide-user/"+name,User.class);
    }
}
