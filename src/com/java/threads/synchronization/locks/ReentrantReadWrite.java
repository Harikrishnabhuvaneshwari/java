package com.java.threads.synchronization.locks;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWrite {
    public static void main(String[] args) throws InterruptedException{
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        Executors.newSingleThreadExecutor().submit(()->{

            readWriteLock.readLock().lock();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ignored){
                // ignored here
            } finally {
                System.out.println("released");
                readWriteLock.readLock().unlock();
            }

        });

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{

            System.out.println(readWriteLock.writeLock().tryLock());
            System.out.println(readWriteLock.writeLock().getHoldCount());
            readWriteLock.writeLock().lock();
            // code to modify shared resource
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            readWriteLock.writeLock().unlock();
        }, 0, 1, TimeUnit.SECONDS);
    }
}
