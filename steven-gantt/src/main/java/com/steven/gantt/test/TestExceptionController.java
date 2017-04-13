package com.steven.gantt.test;

import com.steven.gantt.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Steven on 2017/4/13.
 */
@RequestMapping
public class TestExceptionController {

    /**
     * 测试异常
     * @return
     * @throws Exception
     */
    @RequestMapping("/hello1")
    public String hello1() throws Exception {
        throw new Exception("发生错误");
    }

    /**
     * 测试异常2
     * @return
     * @throws Exception
     */
    @RequestMapping("/hello2")
    public int hello2()  {
        return 100/0;
    }

    /**
     * MyException自定义异常
     * @return
     * @throws MyException
     */
    @RequestMapping("/hello3")
    public String hello3() throws MyException {
        throw new MyException("发生错误2");
    }

    /**
     * 页面级别异常
     * @return
     */
    @RequestMapping("/hello4")
    public int hello4() {
        return 100/0;
    }
}
