package com.steven;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.steven.domain.model.WhiteIp;
import com.steven.page.PageInfo;
import com.steven.service.WhiteIpService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@ContextConfiguration
@RunWith(SpringRunner.class)
//@SpringBootTest
public class WhiteIpTest {

    private Logger logger =  LoggerFactory.getLogger(WhiteIpTest.class);

    @Autowired
    private WhiteIpService whiteIpService;


//    @Before
    public void testInsert() {
        WhiteIp whiteIp = new WhiteIp();
        whiteIp.setUserName("123123");
        whiteIp.setIp("12.12.12.12");
        whiteIpService.insert(whiteIp);

        logger.info(JSON.toJSONString(whiteIp));

    }


    @Test
    public void testFindAll() {
        List<WhiteIp> whiteIps = whiteIpService.findAll();

        logger.info(JSON.toJSONString(whiteIps));
    }


    @Test
    public void testFindByPage() {
        Page<WhiteIp> persons = whiteIpService.findByPage(1, 2);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<WhiteIp> pageInfo = new PageInfo<>(persons);
        Assert.assertNotNull(persons);
        logger.debug(pageInfo.toString());
        logger.debug(JSON.toJSONString(pageInfo));
    }

    @Test
    public void testCacheByPage() {
        long begin = System.currentTimeMillis();
        List<WhiteIp> persons = whiteIpService.findAll();
        long ing = System.currentTimeMillis();
        whiteIpService.findAll();
        long end = System.currentTimeMillis();
        logger.debug("第一次请求时间：" + (ing - begin) + "ms");
        logger.debug("第二次请求时间:" + (end - ing) + "ms");

        Assert.assertNotNull(persons);
        logger.debug(persons.toString());
        logger.debug(JSON.toJSONString(persons));
    }
}
