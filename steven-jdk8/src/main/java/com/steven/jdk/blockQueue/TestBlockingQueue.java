package com.steven.jdk.blockQueue;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * BlockingQueue
 * Created by Steven on 2017/5/25.
 */
public class TestBlockingQueue {

    static long randomTime(){
        return (long) (Math.random() * 1000);
    }

    public static void main(String[] args) {
        // 能容纳100个文件
        final BlockingQueue<File> queue = new LinkedBlockingQueue<File>(100);
        // 线程池
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        final File root = new File("F:\\idea_workspace\\steven-parent\\steven-jdk8\\src\\main\\java\\com\\steven\\");
        //完成标识
        final File exitFile = new File("");
        // 读个数
        final AtomicInteger rc = new AtomicInteger();
        //写个数
        final AtomicInteger wc = new AtomicInteger();
        //读线程
        Runnable read = new Runnable() {
            @Override
            public void run() {

            }

            public void scanFile(File file){
                if(file.isDirectory()){
                    File[] files = file.listFiles(new FileFilter() {
                        @Override
                        public boolean accept(File pathname) {
                            return pathname.isDirectory()||pathname.getPath().endsWith(".java");
                        }
                    });


                    for (File one : files)
                        scanFile(one);
                }else {
                    try {
                        int index = rc.incrementAndGet();
                        System.out.println("Read0: " + index + " "
                                + file.getPath());
                        queue.put(file);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        executorService.submit(read);

        // 四个写线程
        for (int index = 0; index < 4; index++) {
            // write thread
            final int NO = index;
            Runnable write = new Runnable() {
            String threadName = "Write:"+NO;
                @Override
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(randomTime());
                            int index = wc.incrementAndGet();
                            File file = queue.take();
                            // 队列已经无对象
                            if (file == exitFile) {
                                // 再次添加"标志"，以让其他线程正常退出
                                queue.put(exitFile);
                                break;
                            }
                            System.out.println(threadName + ": " + index + " "
                                    + file.getPath());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            executorService.submit(write);


        }

        executorService.shutdown();


    }
}
