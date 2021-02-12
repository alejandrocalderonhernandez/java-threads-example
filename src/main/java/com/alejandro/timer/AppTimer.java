package com.alejandro.timer;

import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

public class AppTimer {

    private static final long TIME_TO_START = 1000;
    private static final long TIME_TO_REPEAT = 1000;

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Some task"
                        .concat(" | Date: ")
                        .concat(LocalTime.now().toString())
                        .concat(" | Thread: ")
                        .concat(Thread.currentThread().getName())
                );
            }
        }, TIME_TO_START, TIME_TO_REPEAT);
    }
}
