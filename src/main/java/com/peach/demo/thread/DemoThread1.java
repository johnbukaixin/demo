package com.peach.demo.thread;

/**
 * Created by panta on 2017/12/13.
 */
public class DemoThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " is running！");

    }
}
