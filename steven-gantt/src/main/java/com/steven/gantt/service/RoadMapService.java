package com.steven.gantt.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.steven.gantt.entity.RoadMap;

import java.util.List;

/**
 * Created by Steven on 2017/3/30.
 */
public interface RoadMapService {

    /**
     * 获取所有roadMap 数据
     * @return
     */
    public List<RoadMap> getRoadMapList();


    /**
     * 保存数据
     * @param roadMap
     * @return
     */
    public int saveRoadMap(RoadMap roadMap);

    /**
     * 根据id查询roadMapDetail
     * @param id
     * @return
     */
    public RoadMap getRoadMapDetailById(long id);


    /**
     * 获取roadMap
     * @param id
     * @return
     */
    public RoadMap getRoadMapInfoDataById(long id);


    /**
     * 更新roadMap信息
     * @param roadMap
     * @return
     */
    public int updateRoadMap(RoadMap roadMap);

    /**
     * 通过id删除roadmap
     * @param id
     * @return
     */
    public int deleteRoadMapById(String id);

    /**
     * 通过id查询road Map Type
     * @param id
     * @return
     */
    public String getRoadTypeById(long id);

    /**
     * 根据parentId获得 roadMap id
     * @param id
     * @return
     */
    public List<RoadMap> getRoadMapIdByParentId(String id);

    /**
     * 获取roadMapNo
     * @return
     */
    public String getRoadMapNo();

    /**
     * 根据roadMapId获取name
     * @param id
     * @return
     */
    public String getRoadMapNameById(long id);


    /**
     * 插入日志信息
     * @param username
     * @param operation
     * @param operationcontent
     * @return
     */
    public int addRoadMapLog(String username, String operation, String operationcontent);


    /**
     * 查询roadmap日志列表
     * @param startIndex
     * @param endIndex
     * @param page
     * @param rows
     * @return
     * @throws JSONException
     */
    JSONObject roadMapLogData(int startIndex, int endIndex, int page, int rows) throws JSONException;


    /**
     * 获取目录的id
     * @param id
     * @return
     */
    public List<Integer> getDirectoryId(String id);

    /**
     * 获取版本的id
     * @param id
     * @return
     */
    public List<Integer> getVersionId(String id);

    /**
     * 获取roadmap信息
     * @param id
     * @return
     */
    public RoadMap getRoadMapAllInfoById(long id);

    /***
     * 通过parentId获取所有roadmap
     * @return
     */
    public List<RoadMap> getRoamMapAllInfoByParentId(long id);

}
