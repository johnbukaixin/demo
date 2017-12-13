package com.peach.demo.thread;

import java.util.concurrent.*;

/**
 * Created by panta on 2017/12/13.
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        //单任务线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        DemoThread1 demoThread = new DemoThread1();
        DemoThread1 demoThread1 = new DemoThread1();
        DemoThread1 demoThread2 = new DemoThread1();

        executorService.execute(demoThread);
        executorService.execute(demoThread1);
        executorService.execute(demoThread2);

        executorService.shutdown();
        System.out.println("----------------------------------------------");
//        //可变尺寸的线程池
        ExecutorService executorService1 = Executors.newCachedThreadPool();

        executorService1.execute(demoThread);
        executorService1.execute(demoThread1);
        executorService1.execute(demoThread2);

        executorService.shutdown();

        ExecutorService executorService2 = Executors.newFixedThreadPool(3);

        executorService2.execute(demoThread);
        executorService2.execute(demoThread1);
        executorService2.execute(demoThread2);

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        pool.execute(demoThread);
        pool.schedule(demoThread,1000, TimeUnit.MILLISECONDS);

    }
}
