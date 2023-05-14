package com.java.parallelstreams.split;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamMapSplitOperation {

    public static void main(String[] args) throws InterruptedException{
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");
        List<Integer> integers = IntStream.rangeClosed(1, 1_000_000_0).boxed().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        integers.forEach(i-> {
            map.put(i,i);
        });

        System.out.println("<--------------------------------------------------------->");
        System.out.println("For larger data sources");
        long start = System.currentTimeMillis();
        map.entrySet().parallelStream().map(Map.Entry::getKey).reduce(0, Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println("Map Reduce time : " + (end - start));



/*        System.out.println("<--------------------------------------------------------->");
        System.out.println("For larger data sources");
        start = System.currentTimeMillis();
        arrayList.parallelStream().collect(Collectors.toSet());
        end = System.currentTimeMillis();
        System.out.println("ArrayList Collect time : " + (end - start));
        start = System.currentTimeMillis();
        linkedList.parallelStream().collect(Collectors.toSet());
        end = System.currentTimeMillis();
        System.out.println("LinkedList Collect time : " + (end - start));*/


    }

}
