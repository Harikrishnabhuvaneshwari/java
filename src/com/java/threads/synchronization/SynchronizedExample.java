package com.java.threads.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class SynchronizedExample {

    public static int counter1 = 0;
    public static int counter2 = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        IntStream.rangeClosed(0, 1000).forEach(i -> {
            executorService.submit(SynchronizedExample::nonSynchronizedIncrement);
        });
        IntStream.range(0, 1000).forEach(i -> {
            executorService.submit(SynchronizedExample::synchronizedIncrement);
        });
        Thread.sleep(5_000);

        System.out.println("Non Synchronized : " + counter1);
        System.out.println("Synchronized : " + counter2);

        executorService.close();
    }

    private static void nonSynchronizedIncrement() {
        counter1 += 1;
    }

    private synchronized static void synchronizedIncrement() {
        counter2 += 1;
    }
}
