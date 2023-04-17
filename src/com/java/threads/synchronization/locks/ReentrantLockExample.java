package com.java.threads.synchronization.locks;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        Executors.newSingleThreadExecutor().submit(() -> {
                System.out.println("submitted");
                reentrantLock.lock();
                System.out.println("locked by : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(5_000);
                    System.out.println(reentrantLock.getHoldCount());
                } catch (InterruptedException ignored) {

                } finally {
                    System.out.println("released by : " + Thread.currentThread().getName());
                    reentrantLock.unlock();
                }
            });

        /*IntStream.rangeClosed(1, 6).forEach(i -> {
            executorService.submit(() -> {
                synchronized (ReentrantLockExample.class) {
                    System.out.println("------>locked by : " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(5_000);
                    } catch (InterruptedException ignored) {

                    } finally {
                        System.out.println("------->released by : " + Thread.currentThread().getName());
                    }
                }
            });
        });*/

        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(() -> {
                    System.out.println("Locked : " + reentrantLock.isLocked());
                    System.out.println("Held by this thread : " + reentrantLock.isHeldByCurrentThread());
                    boolean locked = reentrantLock.tryLock();
                    System.out.println("Locked Acquired : " + locked);
                    reentrantLock.lock();
                    System.out.println("Hold Count : " + reentrantLock.getHoldCount());
//                    reentrantLock.unlock();
                }, 0, 1, TimeUnit.SECONDS);
    }
}
