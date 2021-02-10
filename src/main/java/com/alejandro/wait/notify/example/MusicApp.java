package com.alejandro.wait.notify.example;

public class MusicApp {

    private static final MusicalNotesFactory musicalNotesFactory = new MusicalNotesFactory();
    public static void main(String[] args) {
        Thread supplier = new Thread(musicalNotesFactory.MusicPlayer());
        Thread consumer = new Thread(musicalNotesFactory.listener());
        supplier.start();
        consumer.start();
    }
}
