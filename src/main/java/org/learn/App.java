package org.learn;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Hello world!
 *
 */
public class App {

	// 7800
	// 1000,500,100
	
	
	
	
	
	
	
	
	
	
	
	

	static int minNotes(Integer[] notes, int sum) {

		int notesCount = 0;

		if (sum < 100) {
			return notesCount;
		}

		Arrays.sort(notes, Comparator.reverseOrder());

		for (int note : notes) {
			notesCount += sum / note;
			sum = sum % note;
		}

		return notesCount;
	}

	public static void main(String[] args) {
		System.out.println(minNotes(new Integer[]{100,500,1000}, 700));
	}
	
	

}
