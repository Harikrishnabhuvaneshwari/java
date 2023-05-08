package com.java.threads.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class PlayWithCompletableFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "First Supply Async task");
        //thenApply();
        //thenCompose();
        //thenCombine();

        // Exception handling.
        //exceptionHandling();

        System.out.println(completableFuture.get());
        Thread.sleep(5_000);
    }

    private static void thenApply() {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            // if this task is completed in few ms, then there's a possibility
            // that the following dependent tasks run on main thread instead of the worker thread used by this task.
            // [note : simulating a small delay]
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {
                // do nothing
            }
            System.out.println("thenApply example --->" + Thread.currentThread().getName());
            return 10;
        }).thenApply(result ->
        {
            try {
                System.out.println("thenApply example --->" + Thread.currentThread().getName());
                Thread.sleep(2_000);
            } catch (InterruptedException interruptedException) {

            }
            return String.valueOf(result);
        }).thenAccept(result -> {
            System.out.println("thenApply example --->" + Thread.currentThread().getName());
            System.out.println(result);
        });
    }

    private static void thenCompose() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Future 1 " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
            }
            return "Hello ";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Future 2 " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
            }
            return "World!";
        });

        CompletableFuture<CharSequence> completableFuture = future1
                .thenCompose(s -> {
                    System.out.println("Composing " + Thread.currentThread().getName());
                    return future2.thenApply(result -> s + result);
                });


        System.out.println(completableFuture.join());
    }

    private static void thenCombine() {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
            }
            System.out.println("Computation done by : " + Thread.currentThread().getName());
            return 100;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() ->
        {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
            }
            System.out.println("Computation done by : " + Thread.currentThread().getName());
            return 99;
        });

        CompletableFuture<Integer> completableFuture = future1.thenCombine(future2, Integer::sum); // (a,b)->a+b

        completableFuture.thenAccept(result -> {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException exception) {
            }
            System.out.println("Computation done by : " + Thread.currentThread().getName());
            System.out.print("Combined result : " + result);
        });
    }

    private static void exceptionHandling() {

        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException interruptedException) {

            }
            return 2 / 0;
        });

        // using handle
        completableFuture.handle((result, exception) -> {
            if (exception != null) {
                System.err.println("Exception occurred : " + exception.getMessage());
                return "failed computation";
            } else {
                return result;
            }
        }).thenAccept(System.out::println);

        // using exceptionally
        completableFuture.exceptionally(throwable -> {
            return 0; // default value
        }).thenAccept(System.out::println);


    }
}
