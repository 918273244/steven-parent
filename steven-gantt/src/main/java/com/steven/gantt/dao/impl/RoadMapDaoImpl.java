package com.steven.gantt.dao.impl;

import com.steven.gantt.dao.RoadMapDao;
import com.steven.gantt.entity.RoadMap;
import com.steven.gantt.entity.RoadMapLog;
import com.steven.gantt.mapper.RoadMapMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Steven on 2017/3/30.
 */
@Repository
public class RoadMapDaoImpl implements RoadMapDao {

    @Resource
    private RoadMapMapper roadMapMapper;
    @Override
    public List<RoadMap> getRoadMapList() {
        return roadMapMapper.getRoadMapList();
    }

    @Override
    public int saveRoadMap(RoadMap roadMap) {
        return roadMapMapper.saveRoadMap(roadMap);
    }

    @Override
    public RoadMap getRoadMapDetailById(long id) {
        return roadMapMapper.getRoadMapDetailById(id);
    }

    @Override
    public RoadMap getRoadMapInfoDataById(long id) {
        return roadMapMapper.getRoadMapInfoDataById(id);
    }

    @Override
    public int updateRoadMap(RoadMap roadMap) {
        return roadMapMapper.updateRoadMap(roadMap);
    }

    @Override
    public int deleteRoadMapById(String id) {
        return roadMapMapper.deleteRoadMapById(id);
    }

    @Override
    public String getRoadTypeById(long id) {
        return roadMapMapper.getRoadTypeById(id);
    }

    @Override
    public List<RoadMap> getRoadMapIdByParentId(String id) {
        return roadMapMapper.getRoadMapIdByParentId(id);
    }

    @Override
    public String getRoadMapNo() {
        return roadMapMapper.getRoadMapNo();
    }

    @Override
    public String getRoadMapNameById(long id) {
        return roadMapMapper.getRoadMapNameById(id);
    }

    @Override
    public int addRoadMapLog(String username, String operation, String operationcontent) {
        return roadMapMapper.addRoadMapLog(username,operation,operationcontent);
    }

    @Override
    public List<RoadMapLog> roadMapLogData(int startIndex, int endIndex) {
        return roadMapMapper.roadMapLogData(startIndex, endIndex);
    }

    @Override
    public int getRoadMapLogNum() {
        return roadMapMapper.getRoadMapLogNum();
    }

    @Override
    public List<Integer> getDirectoryId(String id) {
        return roadMapMapper.getDirectoryId(id);
    }

    @Override
    public List<Integer> getVersionId(String id) {
        return roadMapMapper.getVersionId(id);
    }

    @Override
    public RoadMap getRoadMapAllInfoById(long id) {
        return roadMapMapper.getRoadMapAllInfoById(id);
    }

    @Override
    public List<RoadMap> getRoamMapAllInfoByParentId(long id) {
        return roadMapMapper.getRoamMapAllInfoByParentId(id);
    }
}
