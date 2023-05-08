package com.java.threads.completablefuture.order;

public class EnrichOrder {
    public Order enrichOrder(Order order) {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Order enriched with more details");
        return order;
    }
}
