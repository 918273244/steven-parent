package com.steven.service;

import com.steven.model.WhiteIP;
import com.steven.page.WhiteIpPage;

import java.util.List;

public interface WhiteIpService {

    void insert(WhiteIP whiteIp) throws Exception;

    List<WhiteIP> findAll();

    /**
     * 分页查询
     * @param whiteIpPage
     * @return
     */
    List<WhiteIP> findByPage(WhiteIpPage whiteIpPage);

}
