package com.steven.gantt.dao.impl;

import com.steven.gantt.dao.SystemDao;
import com.steven.gantt.entity.RmtSys;
import com.steven.gantt.mapper.SystemMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/21.
 */
@Repository
public class SystemDaoImpl implements SystemDao {
    @Resource
    private SystemMapper systemMapper;

    @Override
    public long addHolidayByDate(String date) {
        return systemMapper.addHolidayByDate(date);
    }

    @Override
    public long deleteHolidayByDate(String date) {
        return systemMapper.deleteHolidayByDate(date);
    }

    @Override
    public int getHolidaySizeByDate(String date) {
        return systemMapper.getHolidaySizeByDate(date);
    }

    @Override
    public List<RmtSys> getListData(int startIndex, int endIndex) {
        return systemMapper.getListData(startIndex,endIndex);
    }

    @Override
    public int addRmt(String name) {
        return systemMapper.addRmt(name);
    }

    @Override
    public int deleteRmtById(long id) {
        return systemMapper.deleteRmtById(id);
    }

    @Override
    public int getRmtNum() {
        return systemMapper.getRmtNum();
    }

    @Override
    public int existRmtByName(String name) {
        return systemMapper.existRmtByName(name);
    }

    @Override
    public List<RmtSys> getAllRmtList() {
        return systemMapper.getAllRmtList();
    }

    @Override
    public RmtSys getRmtById(long id) {
        return systemMapper.getRmtById(id);
    }

}
