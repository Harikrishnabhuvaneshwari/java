package com.java.interfaces.functionalinterfaces;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterface1 {

    public static void main(String[] args) {

        // supplier.

        Supplier<String> supplier = () -> "Hi, I'm Hari how may I serve you?";
        System.out.println(supplier.get());

        // function

        Function<Integer, String> function = String::valueOf; // i -> return String.valueOf(i)
        System.out.println(function.apply(10));

        // consumer

        Consumer<String> consumer = System.out::println; // s -> {System.out.println(s)}
        consumer.accept("Hi, I'm consumer");

        // BiFunction

        BiFunction<Integer, Integer, String> biFunction = (i,j) -> String.valueOf(i+j);
        System.out.println(biFunction.apply(1,2));


    }

}
