package com.alejandro.threads.sync;

public class MySynchronized {

    public static Runnable synchronizedTask(String arg1, String arg2) {
        return () -> {
            try {
                printWords(arg1, arg2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    private synchronized static void printWords(String arg1, String arg2) throws InterruptedException {
        System.out.println(arg1);
        Thread.sleep(500L);
        System.out.println(arg2);
    }
}
