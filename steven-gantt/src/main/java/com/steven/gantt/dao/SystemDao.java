package com.steven.gantt.dao;


import com.steven.gantt.entity.RmtSys;

import java.util.List;

/**
 * Created by Steven on 2017/3/21.
 */
public interface SystemDao {


    long addHolidayByDate(String date);

    long deleteHolidayByDate(String date);

    int getHolidaySizeByDate(String date);

    List<RmtSys> getListData(int startIndex, int endIndex);

    int addRmt(String name);

    int deleteRmtById(long id);

    int getRmtNum();

    int existRmtByName(String name);

    List<RmtSys> getAllRmtList();

    public RmtSys getRmtById(long id);


}
