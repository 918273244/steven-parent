package com.steven.gantt.dao;

import com.steven.gantt.entity.Resources;

import java.util.List;

/**
 * Created by Steven on 2017/4/16.
 */
public interface ResourcesDao {
    List<Resources> getUserResources(String userid);
}
