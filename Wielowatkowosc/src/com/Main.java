package com;

import java.sql.Time;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek apki: " + Thread.currentThread().getName());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Runnable worker1 = () -> {
            try {
                System.out.println("Robotnik 1 | Aktualny wątek : " + Thread.currentThread().getName());
                System.out.println("Laduje butle z tlenem. ");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable worker2 = () -> {
            try {
                System.out.println("Robotnik 2 | Aktualny wątek : " + Thread.currentThread().getName());
                System.out.println("Laduje zapas pozywienia. ");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable worker3 = () -> {
            try {
                System.out.println("Robotnik 3 | Aktualny wątek : " + Thread.currentThread().getName());
                System.out.println("Laduje paliwo. ");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
       /* executor.submit(worker1);
        executor.submit(worker2);
        executor.submit(worker3);*/
        executor.scheduleAtFixedRate(worker3,2,6,TimeUnit.SECONDS);
        executor.shutdown();






        /*       *//* Thread thread = new MyThread("My-Thread-1");

        thread.start();*//*

        Runnable countdown = () -> {
            try {
                System.out.println(" | Wykonywany wątek (countdown) : " + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    //Thread.sleep(1000);
                    TimeUnit.MILLISECONDS.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable blastOff = () -> {
            System.out.println(" | Wykonywany wątek (countdown) : " + Thread.currentThread().getName());
            System.out.println("Blast off!");
        };
       *//* Thread countdownTread = new Thread(countdown, "Countdown");
        Thread blastOfThread = new Thread(blastOff, "Blast off!");
        countdownTread.start();
        countdownTread.join();
        blastOfThread.start();*//*
        executor.submit(countdown);
        executor.submit(blastOff);
        executor.shutdown();*/

    }
}
