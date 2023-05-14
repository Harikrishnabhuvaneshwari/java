package com.java.parallelstreams.split;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamLinkedListSplitOperation {

    public static void main(String[] args) throws InterruptedException{
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "1");
        List<Integer> integers = IntStream.rangeClosed(1, 1_000_000_0).boxed().collect(Collectors.toList());

        List<Integer> linkedList = new LinkedList<>();
        integers.forEach(i-> {
            linkedList.add(i);
        });

        System.out.println("<--------------------------------------------------------->");
        System.out.println("For larger data sources");
        long start = System.currentTimeMillis();
        linkedList.parallelStream().reduce(0, Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println("LinkedList Reduce time : " + (end - start));

        /*System.out.println("<--------------------------------------------------------->");
        System.out.println("For smaller data sources");
        start = System.currentTimeMillis();
        smallArrayList.stream().reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("Seq Reduce time : " + (end - start));
        start = System.currentTimeMillis();
        smallArrayList.parallelStream().reduce(0, Integer::sum);
        end = System.currentTimeMillis();
        System.out.println("Parallel Reduce time : " + (end - start));*/


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

/*        System.out.println("<--------------------------------------------------------->");
        System.out.println("For smaller data sources");
        start = System.currentTimeMillis();
        smallArrayList.stream().collect(Collectors.toSet());
        end = System.currentTimeMillis();
        System.out.println("Seq Collect time : " + (end - start));
        start = System.currentTimeMillis();
        smallArrayList.stream().parallel().collect(Collectors.toSet());
        end = System.currentTimeMillis();
        System.out.println("Parallel Collect time : " + (end - start));*/


    }

}
