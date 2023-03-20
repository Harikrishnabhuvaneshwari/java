package com.java.threads;

import java.util.concurrent.TimeUnit;

public class ThreadLocalExample {
  private static ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

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

    System.out.println("Final count: " + counter.get());
  }
}
