package com;

public class Main {

    public static void main(String[] args) {
        System.out.println("Główny wątek apki: " + Thread.currentThread().getName());
        Thread thread = new MyThread("My-Thread-1");

        thread.start();


        Thread anotherthread = new Thread(
                () -> System.out.println(" | Wykonywany wątek: " + Thread.currentThread().getName()), "My-Runnable-1");
        anotherthread.start();

    }
}
