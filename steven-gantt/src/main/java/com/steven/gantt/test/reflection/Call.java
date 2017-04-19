package com.steven.gantt.test.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

/**
 * Created by Steven on 2017/4/19.
 */
public class Call {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User user = new User();
        user.setUsername("user109");
        user.setPassword("pwd109");
        user.seteBlog("http://www.cnblogs.com/nick-huang/");
        user.setRegistrationDate(new Date());

        Map<String, FieldEntity> map = FieldsCollector.getFileds(user);
        System.out.println(map);
    }
}
