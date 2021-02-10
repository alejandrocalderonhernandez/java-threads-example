package com.alejandro.threads.runnable;

import com.alejandro.threads.thread.MyThreadExtends;

import java.util.stream.IntStream;

public class RunnableThread {
    public static void main(String[] args) {
        Thread myThread1 = new Thread(MyThreadRunnable.creataThtrad("Created by runnable thread 1"));
        Thread myThread2 = new Thread(MyThreadRunnable.creataThtrad("Created by runnable thread 2"));
        myThread1.start();
        myThread2.start();
    }
}
