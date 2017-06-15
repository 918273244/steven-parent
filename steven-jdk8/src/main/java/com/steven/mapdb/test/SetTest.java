package com.steven.mapdb.test;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.NavigableSet;

/**
 * Created by Steven on 2017/6/15.
 */
public class SetTest {
    public static void main(String[] args) {
        //异步写入，关闭事务
        DB db = DBMaker.newFileDB(new File("mapdb.db"))
                .closeOnJvmShutdown().transactionDisable()
                .asyncWriteFlushDelay(100).encryptionEnable("utf-8").make();
        NavigableSet<Object> set = (NavigableSet<Object>) db.getTreeSet("NavigableSet");
        set.add("aaa");
        set.add("bbb");
        System.out.println(set);
    }

}
