package com.steven.mapper;

import com.github.pagehelper.Page;
import com.steven.domain.model.WhiteIp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WhiteIpMapper {

    int insert(WhiteIp whiteIp);

    int deleteByName(String username);

    /**
     * 获取所有数据
     */
    List<WhiteIp> findAll();

    /**
     * 分页查询
     */
    Page<WhiteIp> findByPage();

//    WhiteIp selectByName(String username);

}
