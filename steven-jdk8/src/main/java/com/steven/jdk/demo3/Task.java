package com.steven.jdk.demo3;

import java.util.UUID;

/**
 * 工作任务
 * Created by Steven on 2017/5/18.
 */
public class Task {
    private String id;  // 任务的编号

    public Task() {
        id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Task[" + id + "]";
    }
}
