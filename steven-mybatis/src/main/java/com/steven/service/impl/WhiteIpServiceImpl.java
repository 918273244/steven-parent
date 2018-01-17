package com.steven.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.steven.domain.model.WhiteIp;
import com.steven.mapper.WhiteIpMapper;
import com.steven.service.WhiteIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WhiteIpServiceImpl implements WhiteIpService {

    @Autowired
    WhiteIpMapper whiteIpMapper;

    @Override
    @Transactional
    public void insert(WhiteIp whiteIp) {
        whiteIpMapper.insert(whiteIp);
    }

    @Override
    public List<WhiteIp> findAll() {
        return whiteIpMapper.findAll();
    }

    @Override
    public Page<WhiteIp> findByPage(int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return whiteIpMapper.findByPage();
    }
}
