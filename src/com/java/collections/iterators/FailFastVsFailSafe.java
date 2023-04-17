package com.java.collections.iterators;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVsFailSafe {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        /*
            fail fast
         */
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            // concurrent modification exception - if we modify collection object, while iterating over the same.
            // list.remove(iterator.next());
            iterator.next();
            // if you remove without calling next method, then this call will throw IllegalStateException
            iterator.remove();
        }
        System.out.println(list);

        /*

        not fail fast

         */
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        Iterator<Map.Entry<String, Integer>> iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, Integer> next = iterator1.next();
            System.out.println(next);
            //iterator1.remove();
            // concurrent modification supported because this map is weakly consistent.
            map.put(next.getKey() + next.getValue(), next.getValue());
        }
        System.out.println(map);


        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.add(3);
        copyOnWriteArrayList.add(4);

        Iterator<Integer> iterator2 = copyOnWriteArrayList.iterator();
        while (iterator2.hasNext()) {
            copyOnWriteArrayList.add(iterator2.next());
            //iterator2.remove(); // not supported
        }
        System.out.println(copyOnWriteArrayList);
    }

}
