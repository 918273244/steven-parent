package com.test;


import com.MybatisApplication;
import com.alibaba.fastjson.JSON;
import com.steven.model.WhiteIP;
import com.steven.page.WhiteIpPage;
import com.steven.service.WhiteIpService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class WhiteIpTest {

    private Logger logger =  LoggerFactory.getLogger(WhiteIpTest.class);

    @Autowired
    private WhiteIpService whiteIpService;


//    @Before
    @Test
    public void testInsert() {
        WhiteIP whiteIp = new WhiteIP();
        whiteIp.setUserName("9");
        whiteIp.setIp("12.12.12");
        try {
            whiteIpService.insert(whiteIp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        logger.info(JSON.toJSONString(whiteIp));

    }




    @Test
    public void testFindAll() {
        List<WhiteIP> whiteIps = whiteIpService.findAll();
        logger.info(JSON.toJSONString(whiteIps));
    }


    @Test
    public void testFindByPage() {
        WhiteIpPage whiteIp = new WhiteIpPage();
        whiteIp.setUserName("02322123");
        whiteIp.setCount(20);
        whiteIp.setAsc("desc");

        List<WhiteIP> whiteIps = whiteIpService.findByPage(whiteIp);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        Assert.assertNotNull(whiteIps);
        logger.info(JSON.toJSONString(whiteIps));
    }

    @Test
    public void testCacheByPage() {
        long begin = System.currentTimeMillis();
        List<WhiteIP> persons = whiteIpService.findAll();
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
