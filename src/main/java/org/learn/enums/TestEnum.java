package org.learn.enums;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class TestEnum {
	public static void main(String[] args) {
		DaysOfWeek dayOfWeek = DaysOfWeek.WEDNESDAY;
		System.out.println(dayOfWeek.order);
		for (DaysOfWeek daysOfWeek : DaysOfWeek.values()) {
			System.out.print(daysOfWeek+" ");
		}
		System.out.println();
		
		Map<String, String> hashTable = new Hashtable<>();
		Collections.synchronizedSortedMap(new TreeMap<>());
		Collections.synchronizedSortedSet(new TreeSet<>());
		Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
		
		
		hashTable.put("hari", "priya");
		hashTable.put("priya", "hari");
		hashTable.put("irah", "ayirp");
		System.out.println(hashTable);
		
	}
}
