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
       CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;

        },executor);
        System.out.println(result.get());

        executor.shutdown();

    }
}
