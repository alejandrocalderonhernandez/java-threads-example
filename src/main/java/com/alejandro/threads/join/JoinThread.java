package com.alejandro.threads.join;

import com.alejandro.threads.runnable.MyThreadRunnable;
import com.alejandro.threads.thread.MyThreadExtends;

public class JoinThread {

    public static void main(String[] args) throws InterruptedException {

        Thread myThread1 = new MyThreadExtends("Created by abstract thread 1");
        Thread myThread2 = new MyThreadExtends("Created by abstract thread 2");
        Thread myThread3 = new Thread(MyThreadRunnable.creataThtrad("Created by runnable thread 3"));
        Thread myThread4 = new Thread(MyThreadRunnable.creataThtrad("Created by runnable thread 4"));

        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();

        myThread1.join();
        myThread2.join();
        myThread3.join();
        myThread4.join();

        System.out.println("Continue main thread");

    }
}
