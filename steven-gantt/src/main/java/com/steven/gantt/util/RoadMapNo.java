package com.steven.gantt.util;

/**
 * 按时间long类型生成no.
 * Created by Steven on 2017/4/19.
 */
public class RoadMapNo {

    public static String getNo(){
        long timeMillis = System.currentTimeMillis();
        return "RN"+timeMillis;
    }
}
