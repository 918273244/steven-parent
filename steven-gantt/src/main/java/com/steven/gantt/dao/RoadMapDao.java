package com.steven.gantt.dao;

import com.steven.gantt.entity.RoadMap;
import com.steven.gantt.entity.RoadMapLog;

import java.util.List;

/**
 * Created by Steven on 2017/3/30.
 */
public interface RoadMapDao {
    public List<RoadMap> getRoadMapList();


    public int saveRoadMap(RoadMap roadMap);

    public RoadMap getRoadMapDetailById(long id);

    public RoadMap getRoadMapInfoDataById(long id);

    public int updateRoadMap(RoadMap roadMap);

    public int deleteRoadMapById(String id);

    public String getRoadTypeById(long id);

    public List<RoadMap> getRoadMapIdByParentId(String id);

    public String getRoadMapNo();

    public String getRoadMapNameById(long id);

    public int addRoadMapLog(String username, String operation, String operationcontent);

    public List<RoadMapLog> roadMapLogData(int startIndex, int endIndex);

    public int getRoadMapLogNum();

    public List<Integer> getDirectoryId(String id);

    public List<Integer> getVersionId(String id);

    public RoadMap getRoadMapAllInfoById(long id);

    public List<RoadMap> getRoamMapAllInfoByParentId(long id);
}
