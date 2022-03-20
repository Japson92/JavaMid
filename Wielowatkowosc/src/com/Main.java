package com;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletableFuture<Long> cfuture1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 32L;
        });

        CompletableFuture<Long> cfuture2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2L;
        });

        CompletableFuture<Long> longCompletableFuture = cfuture1.thenCombine(cfuture2, (result1, result2) -> result1 * result2);
        Long aLong = longCompletableFuture.get();
        System.out.println(aLong);


//        CompletableFuture<Void> future = userIdFuture.thenCompose(userId -> CompletableFuture.supplyAsync(() -> getDiscount(userId))).thenAccept((
//                discount -> System.out.println(discount)));
//        future.get();
        executor.shutdown();

    }

    public static Long getUserId() {
        return 142L;
    }

    public static Double getDiscount(Long userId) {
        return 0.25;
    }
}
