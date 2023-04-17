package com.java.threads.synchronization.waitandnotify.goodexample;

import com.java.threads.synchronization.waitandnotify.Data;

public class SynchronizedReceiver implements Runnable {
    private final Data data;
    private String message;

    public SynchronizedReceiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (data) {
            try {
                data.wait();
                Thread.sleep(1000);
                this.message = data.receive();
                System.out.println(this.message);
                System.out.println("received");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public String getMessage() {
        return message;
    }
}