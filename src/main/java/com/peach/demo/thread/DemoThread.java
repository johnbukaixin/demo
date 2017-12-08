package com.peach.demo.thread;

/**
 * Created by panta on 2017/12/7.
 */
public class DemoThread implements Runnable {

    private String threadName;
    private Thread t;

    public DemoThread(String threadName) {
        this.threadName = threadName;
        System.out.println("construct:" + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running:" + threadName);
        for (int i = 4 ; i > 0 ; i--){
            System.out.println("thread:" + threadName +","+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread:" + threadName + "exit");
    }

    public void start(){
        System.out.println("start:" + threadName);
        if (t == null){
            t = new Thread(this,threadName);
            t.start();
        }
    }

    public static  void main(String args[]){
        DemoThread demoThread = new DemoThread("thread1");
        demoThread.start();
        DemoThread demoThread1 = new DemoThread("thread2");
        demoThread1.start();
    }
}
