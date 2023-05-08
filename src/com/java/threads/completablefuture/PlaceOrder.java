package com.java.threads.completablefuture;

import com.java.threads.completablefuture.order.EnrichOrder;
import com.java.threads.completablefuture.order.LoadOrder;
import com.java.threads.completablefuture.order.Payment;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class PlaceOrder {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> ordered = CompletableFuture.supplyAsync(() -> new LoadOrder().loadOrder())
                .thenApply(order -> new EnrichOrder().enrichOrder(order))
                .thenAccept(order -> new Payment().pay(order))
                .thenRun(() -> System.out.println("ordered successfully"))
                .exceptionally(throwableVoidFunction);
        Thread.sleep(10_000);
        ordered.join();

    }

    private static Function<Throwable, Void> throwableVoidFunction = throwable -> {
        System.out.println("----------------------");
        System.out.println("Exception Name :" + throwable.getClass().getName());
        System.out.println("Order Unsuccessful because : " + throwable.getMessage());
        return null;
    };

}
