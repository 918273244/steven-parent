package com.steven.service;

import com.github.pagehelper.Page;
import com.steven.domain.model.WhiteIp;

import java.util.List;

public interface WhiteIpService {

    void insert(WhiteIp whiteIp);

    List<WhiteIp> findAll();

    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页显示记录数
     * @return
     */
    Page<WhiteIp> findByPage(int pageNo, int pageSize);

}
