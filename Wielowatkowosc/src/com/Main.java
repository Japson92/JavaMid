package com;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);

        CompletableFuture.runAsync(
                () -> System.out.println("Wątek : " + Thread.currentThread().getName()), executor
        );
        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;

        }, executor).thenApply(r -> {
            System.out.println(" *2 : " + Thread.currentThread().getName());
            return r * 2;
        }).thenApply(r -> {
            System.out.println(" +1 : " + Thread.currentThread().getName());
            return r + 1;
        }).thenAccept(r -> {
            System.out.println("sout " + Thread.currentThread().getName());
            System.out.println(r);
        });


        executor.shutdown();

    }
}
