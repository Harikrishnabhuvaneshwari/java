package com.java.threads.synchronization.waitandnotify.badexample;

import com.java.threads.synchronization.waitandnotify.Data;

public class Driver {

    public void sendData() throws InterruptedException {
        Data data = new Data();

        UnsynchronizedReceiver receiver = new UnsynchronizedReceiver(data);
        Thread receiverThread = new Thread(receiver, "receiver-thread");
        receiverThread.start();

        UnsynchronizedSender sender = new UnsynchronizedSender(data);
        Thread senderThread = new Thread(sender, "sender-thread");
        senderThread.start();

        senderThread.join(1000);
        receiverThread.join(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        Driver driver = new Driver();
        driver.sendData();
    }
}
