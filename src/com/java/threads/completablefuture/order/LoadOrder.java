package com.java.threads.completablefuture.order;

public class LoadOrder {
    public Order loadOrder() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException interruptedException) {

        }
        System.out.println("Order fetched from DB");
        return new Order();
    }
}
