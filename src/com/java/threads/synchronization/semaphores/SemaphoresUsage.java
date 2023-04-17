package com.java.threads.synchronization.semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoresUsage {

    public static void main(String[] args) {
        // Controls the access to the shared resource by permitting limited access.
        Semaphore semaphore = new Semaphore(5);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable task = () -> {
            try {
                boolean permitted = semaphore.tryAcquire(1, TimeUnit.SECONDS);
                if (permitted) {
                    System.out.println("Semaphore acquired");
                    Thread.sleep(2_000);
                    semaphore.release();
                } else {
                    System.out.println("Could not acquire Semaphore");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        IntStream.of(10).forEach(i -> executorService.submit(task));

        //Output:
        /*
        Semaphore acquired
        Semaphore acquired
        Semaphore acquired
        Semaphore acquired
        Semaphore acquired
        Could not acquire Semaphore
        Could not acquire Semaphore
        Could not acquire Semaphore
        Could not acquire Semaphore
        Could not acquire Semaphore
         */

        executorService.close();
    }

}
