package com.java.threads.synchronization.waitandnotify.goodexample;

import com.java.threads.synchronization.waitandnotify.Data;

public class Driver {

    public void sendData() throws InterruptedException {
        Data data = new Data();

        SynchronizedReceiver receiver = new SynchronizedReceiver(data);
        Thread receiverThread = new Thread(receiver, "receiver-thread");
        receiverThread.start();

        SynchronizedSender sender = new SynchronizedSender(data);
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
