package com.alejandro.wait.notify.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MusicalNotesFactory {
    public String note;
    public boolean canBePlayed;
    private final Set<String> NOTES;

    public MusicalNotesFactory() {
        this.canBePlayed = false;
        this.NOTES = new HashSet<>(Arrays.asList("Do", "Re", "Mi", "Fa", "Sol", "La", "Si"));
    }

    private synchronized void makeNote(String note) {
        while (canBePlayed) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.note = note;
        System.out.println("Making: " + note);
        this.canBePlayed = !this.canBePlayed;
        notify();
    }

    private synchronized void playNote() {
        while (!canBePlayed) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Playing: " + note);
        this.canBePlayed = !this.canBePlayed;
        notify();
    }

    public Runnable MusicPlayer() {
        return () -> {
          this.NOTES.forEach(this::makeNote);
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }

    public Runnable listener() {
        return () -> {
            IntStream.range(0, this.NOTES.size()).forEach(i-> {
                this.playNote();
            });
        };
    }

}
