package com.steven.mapdb.test;

import org.mapdb.DB;
import org.mapdb.DBMaker;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Steven on 2017/6/15.
 */
public class QueuesTest {

    public static void main(String[] args) {
        //异步写入，关闭事务
        DB db = DBMaker.newFileDB(new File("mapdb.db"))
                .closeOnJvmShutdown().transactionDisable()
                .asyncWriteFlushDelay(100).encryptionEnable("utf-8").make();
        BlockingQueue<String> queue = db.getQueue("queue");
        queue.add("abc");
        queue.add("edf");

        System.out.println(queue);
    }

}
