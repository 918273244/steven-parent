package com.steven.jdk.works;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * master-worker模式
 * Created by Steven on 2017/5/26.
 */
public class Master {

    //无阻塞queue
     ConcurrentLinkedQueue<Task> queue = new ConcurrentLinkedQueue<Task>();
    //放入线程到hashMap容器
     HashMap<String, Thread> hashMap = new HashMap<String, Thread>();
    //传入到worker的集合
     ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();
    long startTime = System.currentTimeMillis();

    public Master(Worker worker, int count){
        worker.setQueue(queue);
        worker.setConcurrentHashMap(concurrentHashMap);
        for (int i=0; i<=count;i++){
            hashMap.put("线程："+i,new Thread(worker));
        }
    }

    /**
     * 添加task任务
     * @param task
     */
    public void addQueue(Task task){
        queue.offer(task);
    }


    /**
     * 开始执行
     */
    public void executor(){
        for (Map.Entry<String, Thread> entry : hashMap.entrySet()){
            entry.getValue().start();
        }
    }

    //判断线程是否执行完毕
    public boolean isComplete(){
        for (Map.Entry<String, Thread> entry : hashMap.entrySet()){
            if (entry.getValue().getState()!=Thread.State.TERMINATED){
                return false;
            }
        }
        return true;
    }


    /**
     * 是否所有的子任务都结束了
     * 计算总金额与用时
     */
    public void sum(){
        while (true){
            boolean flag = false;
            for (Map.Entry<String, Thread> entry : hashMap.entrySet()){
                if (entry.getValue().getState()==Thread.State.TERMINATED){
                    flag = true;
                }
            }
            if(flag){
                    long endTime = System.currentTimeMillis();
                    int total = 0;
                for (Map.Entry<String, Object> entry : concurrentHashMap.entrySet()){
                    total +=(int)entry.getValue();
                }
                System.out.println("一共用时:"+(endTime-startTime)+" : 总金额: "+total);
                break;
            }
        }
    }


    public int getResult(){
        int ret = 0;
        for(Map.Entry<String, Object> me : concurrentHashMap.entrySet()){
            //汇总的逻辑..
            ret += (Integer)me.getValue();
        }
        return ret;
    }

}
