package com.steven.gantt.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.steven.gantt.dao.RoadMapDao;
import com.steven.gantt.entity.RoadMap;
import com.steven.gantt.entity.RoadMapLog;
import com.steven.gantt.service.RoadMapService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Steven on 2017/3/30.
 */
@Service
@Transactional
public class RoadMapServiceImpl implements RoadMapService {

    @Resource
    private RoadMapDao roadMapDao;

    @Override
    public List<RoadMap> getRoadMapList() {
        return roadMapDao.getRoadMapList();
    }

    @Override
    public int saveRoadMap(RoadMap roadMap) {
        return roadMapDao.saveRoadMap(roadMap);
    }

    @Override
    public RoadMap getRoadMapDetailById(long id) {
        return roadMapDao.getRoadMapDetailById(id);
    }

    @Override
    public RoadMap getRoadMapInfoDataById(long id) {
        return roadMapDao.getRoadMapInfoDataById(id);
    }

    @Override
    public int updateRoadMap(RoadMap roadMap) {
        return roadMapDao.updateRoadMap(roadMap);
    }

    @Override
    public int deleteRoadMapById(String id) {
        return roadMapDao.deleteRoadMapById(id);
    }

    @Override
    public String getRoadTypeById(long id) {
        return roadMapDao.getRoadTypeById(id);
    }

    @Override
    public List<RoadMap> getRoadMapIdByParentId(String id) {
        return roadMapDao.getRoadMapIdByParentId(id);
    }

    @Override
    public String getRoadMapNo() {
        return roadMapDao.getRoadMapNo();
    }

    @Override
    public String getRoadMapNameById(long id) {
        return roadMapDao.getRoadMapNameById(id);
    }

    @Override
    public int addRoadMapLog(String username, String operation, String operationcontent) {
        return roadMapDao.addRoadMapLog(username, operation, operationcontent);
    }

    @Override
    public JSONObject roadMapLogData(int startIndex, int endIndex, int page, int rows) throws JSONException {
        List<RoadMapLog> list = roadMapDao.roadMapLogData(startIndex, endIndex);
        int num = roadMapDao.getRoadMapLogNum();
        JSONArray jsonResult = new JSONArray();

        JSONObject jsonTemp = null;
        JSONObject jsonObject = new JSONObject();
        int count = 0;
        for (RoadMapLog roadMapLog:list
             ) {
            count++;
            jsonTemp = new JSONObject();
            jsonTemp.put("id",roadMapLog.getId());
            jsonTemp.put("first",roadMapLog.getCreateuser());
            jsonTemp.put("second",roadMapLog.getOperationcontent());
            jsonTemp.put("third",roadMapLog.getCreatetime());
            jsonTemp.put("action",roadMapLog.getOperation());
            jsonResult.add(jsonTemp);
        }
        int total = 0;
        if (num % rows == 0) {
            total = num / rows;
        } else {
            total = num / rows + 1;
        }
        jsonObject.put("rows", jsonTemp);
        jsonObject.put("total", total);
        return jsonObject;
    }

    @Override
    public List<Integer> getDirectoryId(String id) {
        return roadMapDao.getDirectoryId(id);
    }

    @Override
    public List<Integer> getVersionId(String id) {
        return roadMapDao.getVersionId(id);
    }

    @Override
    public RoadMap getRoadMapAllInfoById(long id) {
        return roadMapDao.getRoadMapAllInfoById(id);
    }

    @Override
    public List<RoadMap> getRoamMapAllInfoByParentId(long id) {
        return roadMapDao.getRoamMapAllInfoByParentId(id);
    }
}
