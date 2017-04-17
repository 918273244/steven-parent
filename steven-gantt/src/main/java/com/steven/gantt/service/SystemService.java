package com.steven.gantt.service;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.steven.gantt.entity.RmtSys;

import java.util.List;

/**
 * Created by Steven on 2017/3/21.
 */
public interface SystemService {



    //增加节假日
    long addHolidayByDate(String date);

    //删除节假日
    long deleteHolidayByDate(String date);

    int getHolidaySizeByDate(String date);

    //获取RMT列表
    JSONObject getListData(int startIndex, int endIndex, int page, int rows) throws JSONException;

    //新增rmt
    int addRmt(String name);

    //删除rmt
    int deleteRmtById(long id);

    //判断rmt是否已经存在
    int existRmtByName(String name);
    
    //获取所有RMT信息
    List<RmtSys> getAllRmtList();

    public RmtSys getRmtById(long id);


}
