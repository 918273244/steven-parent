package com.steven.dao;

import com.steven.model.WhiteIP;
import com.steven.page.WhiteIpPage;
import com.steven.dao.base.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface WhiteIpMapper extends BaseMapper<WhiteIP, String>{


//    int insert(WhiteIpPage whiteIp);

    int deleteByName(String username);

    /**
     * 获取所有数据
     */
    List<WhiteIP> findAll();

    /**
     * 分页查询
     */
    List<WhiteIP> findByPage(WhiteIpPage whiteIp);

//    WhiteIp selectByName(String username);

}
