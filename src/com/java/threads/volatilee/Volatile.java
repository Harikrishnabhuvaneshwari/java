package com.java.threads.volatilee;

public class TaskRunner {

    private static int number;
    private static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " is still running....");
            }
            System.out.println(Thread.currentThread().getName() +" execution completed");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Reader().start();
        Thread.sleep(1000);
        ready = true;
        Thread.sleep(100);
        System.out.println("--------------------\n"+Thread.currentThread().getName() +" execution completed");
    }
}