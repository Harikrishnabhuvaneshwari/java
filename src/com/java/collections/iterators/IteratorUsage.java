package com.java.collections.iterators;

import java.util.*;

public class IteratorUsage {

    public static void main(String[] args) {
        //List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.print(next+ " ");
            //iterator.remove();
        }
        System.out.println("\n"+list);

        Spliterator<Integer> spliterator = list.spliterator();

        Spliterator<Integer> spliterator2 = spliterator.trySplit();
        System.out.println("Spliterator produced by splitting iterator :");
        spliterator2.forEachRemaining(System.out::println);
        System.out.println("Rest of spliterator");
        spliterator.forEachRemaining(System.out::println);
    }


}
