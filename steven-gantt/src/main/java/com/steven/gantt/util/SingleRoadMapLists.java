package com.steven.gantt.util;


import com.steven.gantt.entity.RoadMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steven on 2017/4/6.
 */
public class SingleRoadMapLists {

    private static List<RoadMap> roadMapList = new ArrayList<RoadMap>();

    private SingleRoadMapLists(){
        super();
    }

    public static List<RoadMap> getInstance(){
        return roadMapList;
    }


}
