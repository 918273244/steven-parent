package com.steven.netty.demo.service;

import com.steven.netty.nettyrest.ApiProtocol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {

    protected ApiProtocol apiProtocol;
    protected Logger logger;

    public BaseService(ApiProtocol apiProtocol) {
        this.apiProtocol = apiProtocol;
        logger = LoggerFactory.getLogger(this.getClass());
    }
}
