package com.alejandro.threads.thread;

public class ExtendsThread {

    public static void main(String[] args) {
        Thread myThread1 = new MyThreadExtends("Created by abstract thread 1");
        Thread myThread2 = new MyThreadExtends("Created by abstract thread 2");
        myThread1.start();
        myThread2.start();
    }
}
