package com;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        Callable<Integer> answerToEverything = () -> {
            TimeUnit.SECONDS.sleep(12);
            return 42;
        };
        Callable<Integer> anotherAnswerToEverything = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 48;
        };
        Callable<Integer> finalAnswerToEverything = () -> {
            TimeUnit.SECONDS.sleep(6);
            return 56;
        };

        List<Callable<Integer>> callableList = Arrays.asList(answerToEverything, anotherAnswerToEverything, finalAnswerToEverything);

        List<Future<Integer>> futures = executor.invokeAll(callableList);

        Integer integer = executor.invokeAny(callableList);
        System.out.println(integer);
//        for (Future<Integer> f : futures){
//            System.out.println(f.get());
//        }
        executor.shutdown();

    }
}
