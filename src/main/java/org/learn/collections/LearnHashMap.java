package org.learn.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LearnHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// load factor - 0.75
		// threshold - 12 (load factor * size). If threshold size is crossed
		// then map size is doubled(ex:16 to 32) and threshold is changed to
		// 0.75 * new size.
		// default capacity 16

		Map<Pojo, Integer> map = new HashMap<>(20);

		/**
		 * PUT OPERATION OVERVIEW.
		 * 
		 * 1. calculate hash of key
		 * 2. calculate index value of table using the hash generated.
		 * 3. check if that bucket already has a node.
		 *  if node is present recursively check the key of node is equal to the key given, if equal then override node value with new value,
		 *  else create a node and add to end of the existing node
		 * else create a node and put it in the calculated index of array of buckets.
		 * 
		 * NOTE : null key is always inserted at 0th index of node table.
		 * 
		 * NOTE : In case of hash collision, if Key is different then add node to the next pointer of existing node in that bucket.
		 * 
		 */
		System.out.println("PUT OPERATION OVERVIEW");
		map.put(new Pojo("AAA"), 6);
		map.put(new Pojo("AC"), 3);
		map.put(new Pojo("AA"), 1);
		map.put(new Pojo("AB"), 2);
		map.put(new Pojo("AD"), 4);
		map.put(null, 1);
		System.out.println(map);
		
		/**
		 * GET OPERATION OVERVIEW.
		 * 
		 * 1. calculate hash of key
		 * 2. calculate index value of table using the hash generated.
		 * 3. check if that bucket has a node.
		 *  if node is present recursively check the key of node is equal to the key given, if equal then return the (Key, Value),
		 *  else return null.
		 * else return null.
		 * 
		 */
		System.out.println("\nGET OPERATION OVERVIEW");
		System.out.println(map.get(new Pojo("AD")));
		System.out.println(map.get(null));
		System.out.println(map.get(new Pojo("AAA")));
		
		
		Set<Entry<Pojo, Integer>> entry = map.entrySet();
		Set<Pojo> keySet = map.keySet();
		keySet.remove(new Pojo("AD"));
		
		System.out.println(entry);
		System.out.println(map.keySet());
		entry.remove(null);
		map.put(new Pojo("AD"), 400);
		
		System.out.println(map.keySet());
		System.out.println(entry);
	}

}
