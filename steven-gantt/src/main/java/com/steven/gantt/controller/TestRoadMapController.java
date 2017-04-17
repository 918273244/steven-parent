/*
package com.steven.gantt.controller;

import com.github.pagehelper.PageHelper;
import com.steven.gantt.entity.RoadMap;
import com.steven.gantt.mapper.RoadMapMapper;
import com.steven.gantt.service.UserService;
//import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

*/
/**
 * Created by Steven on 2017/4/12.
 *//*

@Controller
@RequestMapping("/api")
public class TestRoadMapController {

    @Resource
    private RoadMapMapper roadMapMapper;
    @Resource
    private UserService userService;

    @RequestMapping("/getRoadMap")
    @ResponseBody
    public List<RoadMap> getRoadMap(int pageNum){

        //第一个参数表示第几页,第二个显示每页数量
        PageHelper.startPage(pageNum,2);
        List<RoadMap> list = roadMapMapper.getRoadMapList();
        return list;
    }

    */
/**
     * spring boot 测试
     * @return
     *//*

    @RequestMapping("/test")
    public String test(){
        System.out.println("new day");
        return "user/user";
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public int saveUser(String username, String password){
//        Md5PasswordEncoder md5 = new Md5PasswordEncoder ();
//         password = md5.encodePassword(username, password);
        return userService.saveUser(username,password,"ROLE_USER");
    }

    @RequestMapping("/registerView")
    public String registerView(){

        return "register";
    }



}
*/
