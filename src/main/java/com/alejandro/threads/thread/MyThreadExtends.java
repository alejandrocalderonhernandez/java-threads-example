package com.alejandro.threads.thread;

public class MyThreadExtends extends Thread {

    public MyThreadExtends(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Start MyThread: " + super.getName());
        for (int i = 0; i<10; i++) {
            System.out.println("Some task by: " + super.getName());
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println("End MyThread: " + super.getName());
    }
}
