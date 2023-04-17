package com.java.threads.synchronization.waitandnotify.goodexample;

import com.java.threads.synchronization.waitandnotify.Data;


class SynchronizedSender implements Runnable {
    private final Data data;

    public SynchronizedSender(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (data) {
            try {
                System.out.println("sender");
                Thread.sleep(1000);
                data.send("test");
                System.out.println("sent");
                data.notifyAll();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}