package com.java.threads.synchronization.waitandnotify.badexample;

import com.java.threads.synchronization.waitandnotify.Data;


class UnsynchronizedSender implements Runnable {
    private final Data data;

    public UnsynchronizedSender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            data.send("test");
            System.out.println("sent");
            data.notifyAll();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}