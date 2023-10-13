package com.java17.records;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Driver {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        Map<String, Integer> test = new HashMap<>();
        test.put("", 1);
        var studentRecord1 = new StudentRecord(test, list);
        System.out.println(studentRecord1);
        test.put("", 1);
        var studentRecord2 = new StudentRecord(test, list);
        System.out.println(studentRecord2);
        System.out.println(studentRecord1.equals(studentRecord2));

        list.add(4); // to prove that record doing shallow copy instead of deep copy
        System.out.println(studentRecord1);
        System.out.println(studentRecord2);
    }

}
