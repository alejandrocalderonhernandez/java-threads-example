package com.alejandro.threads.runnable;

import java.util.stream.IntStream;

public class MyThreadRunnable {

    public static Runnable creataThtrad(String name) {
        return  () -> {
            IntStream it= IntStream.range(0, 10);
            System.out.println("Some task by: " + name);
            it.forEach(i -> {
                System.out.println("Some task by: " + name);
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            });
            System.out.println("End MyThread: " + name);
        };
    }
}
