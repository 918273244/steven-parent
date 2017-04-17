package com.steven.gantt.mapper;

import com.steven.gantt.entity.Resources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Steven on 2017/4/16.
 */
@Mapper
public interface ResourcesMapper {

    @Select("SELECT * FROM RESOURCES WHERE id in(SELECT resc_id FROM resources_role WHERE role_id in("
            + "SELECT role_id FROM user_role WHERE user_id=#{userId}))")
    List<Resources> getUserResources(String userid);

}
