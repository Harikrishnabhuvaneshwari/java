package com.java.parallelstreams.memorylocality;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MemoryLocality {
    public static void main(String[] args) {
        List<Integer> numbers = IntStream.rangeClosed(1, 1_000_000_0).boxed().collect(Collectors.toList());
        int[] primitive = new int[1_000_000_0];
        Integer[] object = new Integer[1_000_000_0];
        numbers.forEach(i -> {
            primitive[i - 1] = i;
            object[i - 1] = i;
        });

        long start = System.currentTimeMillis();
        Arrays.stream(primitive).reduce(0, Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println("Primitive Reduce : "+ (end-start));
        start = System.currentTimeMillis();
        Arrays.stream(primitive).parallel().reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("Primitive Parallel Reduce : "+ (end-start));
        start = System.currentTimeMillis();
        Arrays.stream(object).reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("Object Reduce : "+ (end-start));
        start = System.currentTimeMillis();
        Arrays.stream(object).parallel().reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("Object Parallel Reduce : "+ (end-start));
    }
}
