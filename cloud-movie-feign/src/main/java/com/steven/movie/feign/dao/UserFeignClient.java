package com.steven.movie.feign.dao;

import com.steven.movie.feign.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 使用@FeignClient("microservice-provider-user")注解绑定microservice-provider-user服务，还可以使用url参数指定一个URL。
 * Created by Steven on 2017/5/5.
 */
@FeignClient(name = "provide-user")
public interface UserFeignClient {

    @RequestMapping("/{name}")
    public User getUserByNames(@RequestParam("name") String name);

    @RequestMapping("/userList")
    public List<User> userList();

    @RequestMapping("/saveUser")
    public String saveUser(@RequestParam("username")String username,@RequestParam("password") String password);
}
