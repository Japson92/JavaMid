package com;

public class Main {

    public static void main(String[] args) {
        System.out.println("Główny wątek apki: " + Thread.currentThread().getName());
        Thread thread = new MyThread("My-Thread-1");

        thread.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(" | Wykonywany wątek (runable): " + Thread.currentThread().getName());
            }
        };
        Thread anotherthread = new Thread(runnable, "My-Runnable-1");
        anotherthread.start();

    }
}
