package com.steven.gantt.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.steven.gantt.dao.SystemDao;
import com.steven.gantt.entity.RmtSys;
import com.steven.gantt.service.SystemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Steven on 2017/3/21.
 */
@Service
@Transactional
public class SystemServiceImpl implements SystemService {
    @Resource
    private SystemDao systemDao;

    @Override
    public long addHolidayByDate(String date) {
        return systemDao.addHolidayByDate(date);
    }

    @Override
    public long deleteHolidayByDate(String date) {
        return systemDao.deleteHolidayByDate(date);
    }

    @Override
    public int getHolidaySizeByDate(String date) {
        return systemDao.getHolidaySizeByDate(date);
    }

    @Override
    public JSONObject getListData(int startIndex, int endIndex, int page, int rows) throws JSONException {
        List<RmtSys> rmtList = systemDao.getListData(startIndex, endIndex);
        int num = systemDao.getRmtNum();
        JSONArray jsonResult = new JSONArray();
        JSONObject jsonTemp = null;
		JSONObject jsonObject =  new JSONObject();
        int count = 0;
        for(RmtSys rmt : rmtList)
        {
            count++;
            jsonTemp = new JSONObject();
            jsonTemp.put("id", rmt.getId());
            jsonTemp.put("sequence", rmt.getId());
            jsonTemp.put("first", rmt.getRmtName());
            jsonTemp.put("action", "<a href='javascript:void(0)'onclick='del("+rmt.getId()+")'title='Delete'> <i class='fa fa-trash i_size i_size'></i></a>");
            jsonResult.add(jsonTemp);
        }

        int total = 0;
        if (num % rows == 0) {
            total = num / rows;
        } else {
            total = num / rows + 1;
        }

		jsonObject.put("total", total);
		jsonObject.put("rows", jsonResult);
        return jsonObject;
    }

    @Override
    public int addRmt(String name) {
        return systemDao.addRmt(name);
    }

    @Override
    public int deleteRmtById(long id) {
        return systemDao.deleteRmtById(id);
    }

    @Override
    public int existRmtByName(String name) {
        return systemDao.existRmtByName(name);
    }


    @Override
    public List<RmtSys> getAllRmtList() {
        return systemDao.getAllRmtList();
    }

    @Override
    public RmtSys getRmtById(long id) {
        return systemDao.getRmtById(id);
    }


}
