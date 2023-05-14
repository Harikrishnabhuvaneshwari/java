package com.java.parallelstreams.merge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SeqMergeOperation {

    public static void main(String[] args) throws InterruptedException{
        List<Integer> integers = IntStream.rangeClosed(1, 1_000_000_0).boxed().collect(Collectors.toList());
        List<Integer> arrayList = new ArrayList<>(integers);

        System.out.println("<--------------------------------------------------------->");
        System.out.println("For larger data sources - reduce operation");
        long start = System.currentTimeMillis();
        arrayList.stream().reduce(0, Integer::sum);
        long end = System.currentTimeMillis();
        System.out.println("Seq Reduce time (merging cost) : " + (end - start));
    }

}
