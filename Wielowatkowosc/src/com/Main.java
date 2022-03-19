package com;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Główny wątek apki: " + Thread.currentThread().getName());
       /* Thread thread = new MyThread("My-Thread-1");

        thread.start();*/

        Runnable countdown = () -> {
            try {
                System.out.println(" | Wykonywany wątek (countdown) : " + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    //Thread.sleep(1000);
                    TimeUnit.SECONDS.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable blastOff = () -> {
            System.out.println(" | Wykonywany wątek (countdown) : " + Thread.currentThread().getName());
            System.out.println("Blast off!");
        };
        Thread countdownTread = new Thread(countdown, "Countdown");
        Thread blastOfThread =  new Thread(blastOff, "Blast off!");
        countdownTread.start();
        countdownTread.join();
        blastOfThread.start();

    }
}
