package com.java.threads.completablefuture.order;

public class Payment {

    public void pay(Order order) {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException interruptedException) {

        }
        System.out.println("Paid Successfully by :" + Thread.currentThread().getName());
    }

}
