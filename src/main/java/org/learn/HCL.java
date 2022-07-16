package org.learn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HCL {

	// ["R","R","R","R","Y","G","G"]
	// bucket of shocks
	// param - list/array
	
	static void printPairs(List<String> bucket){
		//identify unique color
		Set<String> uniqueColors = new HashSet<>();
		uniqueColors.addAll(bucket);
		
		for (String color : uniqueColors) {
			long count = bucket.stream().filter(shock -> shock.equals(color)).count();
			System.out.println(color +" : " + count/2);
		}
	
	}
	
	public static void main(String[] args) {
		printPairs(Arrays.asList("R","R","R","R","Y","G","G"));
	}
	
}
