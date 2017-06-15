package com.steven.mapdb.test;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * mapdb test
 * Created by Steven on 2017/6/15.
 */
public class MapTest {

    public static void main(String[] args) {
//        System.out.println(File.separatorChar);
        //fluet式    无则创建，有则打开，需密码校验
        DB db =DBMaker.newFileDB(new File("mapdb.db")).closeOnJvmShutdown().encryptionEnable("utf-8").make();
        ConcurrentNavigableMap<Integer,String> map = db.getTreeMap("ConcurrentMap");
        map.put(1,"test1");
        map.put(2,"test2");
        //提交持久化
        db.commit();

        map.put(3, "test3");
        // map.keySet() is  [1,2,3]
        System.out.println(map);

        //回滚
        db.rollback();
        // map.keySet() is  [1,2]
        System.out.println(map);
        db.close();
    }

}
