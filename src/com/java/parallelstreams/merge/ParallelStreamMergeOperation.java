package com.java.parallelstreams.merge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamMergeOperation {

    public static void main(String[] args) throws InterruptedException{
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");
        List<Integer> integers = IntStream.rangeClosed(1, 1_000_000_0).boxed().collect(Collectors.toList());
        List<Integer> arrayList = new ArrayList<>(integers);
        List<Integer> smallIntegers = IntStream.rangeClosed(1, 1_000_00).boxed().collect(Collectors.toList());
        List<Integer> smallArrayList = new ArrayList<>(smallIntegers);

        System.out.println("<--------------------------------------------------------->");
        System.out.println("For larger data sources");
        long start = System.currentTimeMillis();
        arrayList.parallelStream().reduce(0, Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println("Parallel Reduce time : " + (end - start));

        System.out.println("<--------------------------------------------------------->");
        System.out.println("For smaller data sources");
        start = System.currentTimeMillis();
        smallArrayList.stream().reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("Seq Reduce time : " + (end - start));
        start = System.currentTimeMillis();
        smallArrayList.parallelStream().reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("Parallel Reduce time : " + (end - start));


        System.out.println("<--------------------------------------------------------->");
        System.out.println("For larger data sources");
        start = System.currentTimeMillis();
        arrayList.stream().collect(Collectors.toSet());
        end = System.currentTimeMillis();
        System.out.println("Seq Collect time : " + (end - start));
        start = System.currentTimeMillis();
        arrayList.stream().parallel().collect(Collectors.toSet());
        end = System.currentTimeMillis();
        System.out.println("Parallel Collect time : " + (end - start));

        System.out.println("<--------------------------------------------------------->");
        System.out.println("For smaller data sources");
        start = System.currentTimeMillis();
        smallArrayList.stream().collect(Collectors.toSet());
        end = System.currentTimeMillis();
        System.out.println("Seq Collect time : " + (end - start));
        start = System.currentTimeMillis();
        smallArrayList.stream().parallel().collect(Collectors.toSet());
        end = System.currentTimeMillis();
        System.out.println("Parallel Collect time : " + (end - start));


    }

    private static void seqStream(List<Integer> numbers) {
        long start = System.currentTimeMillis();
        System.out.println("Seq result : " + numbers.stream().reduce(5, Integer::sum));
        long end = System.currentTimeMillis();
        System.out.println("Seq time : " + (end - start));

    }

    private static void parallelStream(List<Integer> numbers) {
        long start = System.currentTimeMillis();
        System.out.println("Parallel result : " + numbers.parallelStream().reduce(5, (a, b) -> {
            //System.out.println(Thread.currentThread().getName() + " "+a+" "+b);
            return a + b;
        }));
        long end = System.currentTimeMillis();
        System.out.println("Parallel time : " + (end - start));
    }

}
