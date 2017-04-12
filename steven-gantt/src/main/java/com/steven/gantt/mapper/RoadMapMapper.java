package com.steven.gantt.mapper;

import com.steven.gantt.entity.RoadMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;



/**
 * Created by Steven on 2017/4/12.
 */
@Mapper
public interface RoadMapMapper {

    @Select("select ID, ROADNO, PARENTID,case roadMapType when 0 then 'root' when 1 then 'leaf' end as roadMapTypeValue from ROADMAP")
    public List<RoadMap> getRoadMapList();
}
