package com.steven.gantt.controller;

import com.steven.gantt.entity.RoadMap;
import com.steven.gantt.mapper.RoadMapMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Steven on 2017/4/12.
 */
@Controller
public class TestRoadMapController {

    @Resource
    private RoadMapMapper roadMapMapper;

    @RequestMapping("/getRoadMap")
    @ResponseBody
    public List<RoadMap> getRoadMap(){
        List<RoadMap> list = roadMapMapper.getRoadMapList();
        return list;
    }

    @RequestMapping("/test")
    public String test(){
        System.out.println("new day");
        return "user/user";
    }

}
