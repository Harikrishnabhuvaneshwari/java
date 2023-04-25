package com.java.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonDriver {
    public static void main(String[] args) throws NoSuchMethodException, InterruptedException {

        System.out.println("Enum : " + EnumSingleton.INSTANCE.hashCode());
        System.out.println("Enum : " + EnumSingleton.INSTANCE.hashCode());

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Runnable simpleTask = () -> System.out.println("BillPughSingleton : " + BillPughSingleton.getInstance().hashCode());
        for (int i = 0; i < 5; i++) {
            executorService.submit(simpleTask);
        }
        Thread.sleep(2000);
        Runnable billPughTask = () -> System.out.println("Simple Singleton : " + SimpleSingleton.getInstance().hashCode());
        for (int i = 0; i < 5; i++) {
            executorService.submit(billPughTask);
        }
        executorService.close();
    }
}
