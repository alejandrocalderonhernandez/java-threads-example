package com.alejandro.executor.example;

import java.util.concurrent.*;

public class App {

    private static final int START_NUMBER_THREADS = 1;
    private static final int MAX_NUMBER_THREADS = 3;
    private static final long TIME_OF_LIFE_FOR_MAX_NUMBER_THREADS = 300L;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(START_NUMBER_THREADS);
        executor.setMaximumPoolSize(MAX_NUMBER_THREADS);
        executor.setKeepAliveTime(TIME_OF_LIFE_FOR_MAX_NUMBER_THREADS, TimeUnit.MILLISECONDS);
        Callable<Integer> taskInt = () -> {
            TimeUnit.SECONDS.sleep(1L);
            return 1;
        };

        Callable<String> taskString = () -> {
            TimeUnit.SECONDS.sleep(1L);
            return "Hello wold";
        };

        Callable<Boolean> taskBoolean = () -> {
            TimeUnit.SECONDS.sleep(1L);
            return true;
        };

        Future<?> future1 = executor.submit(taskInt);
        Future<?> future2 = executor.submit(taskString);
        Future<?> future3 = executor.submit(taskBoolean);

        executor.shutdown();
        while (!(future1.isDone() && future2.isDone() && future3.isDone())) {
            System.out.println(String.format("Process int %s | Process string %s | Process boolean %s",
                    future1.isDone() ? "Finished" : "Executing",
                    future2.isDone() ? "Finished" : "Executing",
                    future3.isDone() ? "Finished" : "Executing"));
            TimeUnit.MILLISECONDS.sleep(300L);
        }

    }
}
