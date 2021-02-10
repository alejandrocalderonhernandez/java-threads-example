package com.alejandro.threads.sync;

public class SynchronizedThread {

    public static void main(String[] args) {
        Thread myThread1 = new Thread(MySynchronized.synchronizedTask("Hello ", "World"));
        Thread myThread2 = new Thread(MySynchronized.synchronizedTask("Java ", "Kotlin"));
        Thread myThread3 = new Thread(MySynchronized.synchronizedTask("Angular ", "React"));

        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

}
