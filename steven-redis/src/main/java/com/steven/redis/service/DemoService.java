package com.steven.redis.service;

import com.steven.redis.entity.Address;
import com.steven.redis.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Steven on 2017/5/16.
 */
@Service
public class DemoService {

    @Cacheable(value = "usercache",keyGenerator = "wiselyKeyGenerator")
    public User findUser(Long id, String firstName, String lastName){
        System.out.println("无缓存的时候调用这里");
        return new User(id,firstName,lastName);
    }

    @Cacheable(value = "addresscache",keyGenerator = "wiselyKeyGenerator")
    public Address findAddress(Long id, String province, String city){
        System.out.println("无缓存的时候调用这里");
        return new Address(id,province,city);
    }

}
