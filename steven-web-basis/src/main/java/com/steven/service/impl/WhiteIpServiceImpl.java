package com.steven.service.impl;

import com.steven.config.annotation.DataSource;
import com.steven.model.WhiteIP;
import com.steven.page.WhiteIpPage;
import com.steven.dao.WhiteIpMapper;
import com.steven.service.WhiteIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WhiteIpServiceImpl implements WhiteIpService {

    @Autowired
    WhiteIpMapper whiteIpMapper;

    @Override
    @DataSource(name = DataSource.master)
    @Transactional
    public void insert(WhiteIP whiteIp)  {
        try {
            whiteIpMapper.insert(whiteIp);
            /**
             * 测试事务功能
             */
          /*  String str = null;
            if(str.equals("")){
                System.out.println("22222");
            }
            whiteIpMapper.insert(whiteIp);*/
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    @Override
    @DataSource(name = DataSource.slave)
    public List<WhiteIP> findAll() {
        return whiteIpMapper.findAll();
    }

    @Override
    @DataSource(name = DataSource.master)
    public List<WhiteIP> findByPage(WhiteIpPage whiteIpPage) {
        return whiteIpMapper.findByPage(whiteIpPage);
    }
}
