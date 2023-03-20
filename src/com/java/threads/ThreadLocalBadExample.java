package com.java.threads;

import java.util.concurrent.TimeUnit;

public class ThreadLocalBadExample {


    private static ThreadLocal<Integer> counter = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        Runnable task = () -> {
            int count = counter.get();
            counter.set(count + 1);
            System.out.println("Thread " + Thread.currentThread().getId() + " count: " + counter.get());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // accesing the threadlocal variable outside the threads (I mean in main thread here).
        // as we know that thread local isolates the state of the Object to that particular thread
        // so here you can see that changes done by other threads above has no effect here.
        int count = counter.get();
        counter.set(count + 1);
        System.out.println("Final count: " + counter.get());
    }
}

