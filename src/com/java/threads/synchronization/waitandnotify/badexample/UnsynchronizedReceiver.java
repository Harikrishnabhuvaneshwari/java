package com.java.threads.synchronization.waitandnotify.badexample;

import com.java.threads.synchronization.waitandnotify.Data;

public class UnsynchronizedReceiver implements Runnable {
    private final Data data;
    private String message;

    public UnsynchronizedReceiver(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            data.wait();
            //Thread.sleep(1000);
            this.message = data.receive();
            System.out.println(this.message);
            System.out.println("received");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}