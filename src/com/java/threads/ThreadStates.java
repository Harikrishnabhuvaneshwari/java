package com.java.threads;

public class ThreadStates extends Thread {

    @Override
    public void run() {
        try {
            // TIMED WAITING - when you ask thread to wait for sometime before terminating it'll be in this state.
            Thread.currentThread().join(3000);
            System.out.println("Timed waiting completed");
            // Note : if you don't pass any time, then the thread will be in WAITING state forever
            // until you disturb it.
        } catch (Exception exception) {
            // do nothing....
        }

    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStates threadStates = new ThreadStates();

        // NEW state - when  you basically create a thread it'll be in this state.
        Thread thread1 = new Thread(threadStates);
        System.out.println(thread1.getName() + " : " + thread1.getState());

        thread1.start();
        // RUNNABLE state - The thread is said to be in runnable state if it got
        // started/waiting for CPU to allocate resources.
        System.out.println(thread1.getName() + " : " + thread1.getState());

        Thread.sleep(1000);
        System.out.println(thread1.getName() + " : " + thread1.getState());


        System.out.println("------------------Interrupting thread which is in timed waiting state above -----------------");
        thread1.interrupt();
        System.out.println(thread1.getName() + " is interrupted ? :" + thread1.isInterrupted());
        System.out.println(thread1.getName() + " is alive ? :" + thread1.isAlive());


        // TERMINATED - Thread is said to be terminated when it completes its execution.
        System.out.println(thread1.getName() + " : " + thread1.getState());
    }

}
