package com;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Główny wątek apki: " + Thread.currentThread().getName());
        Thread thread = new MyThread("My-Thread-1");

        thread.start();

        Runnable runnable = () -> {
            try {
                System.out.println(" | Wykonywany wątek: " + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    //Thread.sleep(1000);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread anotherthread = new Thread(runnable, "My-Runnable-1");
        anotherthread.start();

    }
}
