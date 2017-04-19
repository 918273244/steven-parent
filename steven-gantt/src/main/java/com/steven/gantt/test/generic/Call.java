package com.steven.gantt.test.generic;

/**
 * Created by Steven on 2017/4/19.
 */
public class Call {

    public static void main(String[] args) {
        User user = new User();
        user.setName("Steven");
        BaseDao<User> baseDao = new BaseDao<User>();
//        User user1 = baseDao.getDetail();
        System.out.println(baseDao.getLength(user).getName());
    }
}
