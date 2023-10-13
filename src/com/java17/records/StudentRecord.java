package com.java17.records;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public record StudentRecord(int id, String name, List<Integer> list) implements Predicate<String>, Function<Integer, String> {
    public static int age = 28;

    public StudentRecord {
        System.out.println("inside compact canonical constructor");
    }


    public StudentRecord(Map<String, Integer> map, List<Integer> integerList) {
        this(map.get(""),"Hari Krishna", integerList);
        if((id << 1) == 2) {
            System.out.println("BITWISE LEFT SHIFT SATISFIED");
        }
    }

    public StudentRecord(List<Integer> dummyList) {
        this(1,"Hari Krishna", Arrays.asList(1,2,3));
        if((id << 1) == 2) {
            System.out.println("BITWISE LEFT SHIFT SATISFIED");
        }
    }

    @Override
    public boolean test(String test){
        return true;
    }

    /**
     * Applies this function to the given argument.
     *
     * @param integer the function argument
     * @return the function result
     */
    @Override
    public String apply(Integer integer) {
        return null;
    }
}
