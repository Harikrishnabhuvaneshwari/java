package org.learn;

import java.util.Arrays;
import java.util.List;

public class FindNo {

	public static boolean findNo(int[][] arr, int val) {
		for (int[] eachArr : arr) {
			Arrays.sort(eachArr);
			if (Arrays.binarySearch(eachArr, val) > 0) {
				return true;
			}
		}
		return false;
	}

	// { 1, 3, 5, 7 } 10;

	static void printPairs(int[] arr, int val) {
		
//		for (int i = 0; i < arr.length; i++) {
//
//		}

	}

	public static void main(String[] args) {
		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		System.out.println(findNo(arr, 16));
	}

}
