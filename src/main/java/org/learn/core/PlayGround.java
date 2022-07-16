package org.learn.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class PlayGround implements Comparable<PlayGround> {

	String name;

	public PlayGround(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		Set<String> hashSet = new HashSet<>();
		hashSet.addAll(Arrays.asList("e", "d", "c", "b", "a", "g", "p"));
		System.out.println("HashSet ---------->" + hashSet);

		Set<String> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.addAll(Arrays.asList("e", "d", "c", "b", "a", "g", "p"));
		System.out.println("LinkedHashSet ---->" + linkedHashSet);

		Set<String> treeSet = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		treeSet.addAll(Arrays.asList("e", "d", "c", "b", "a", "g", "p"));
		System.out.println("TreeSet ---------->" + treeSet);
	}

	@Override
	public int compareTo(PlayGround o) {
		return this.name.compareTo(o.name);
	}

	@Override
	public String toString() {
		return "PlayGround [name=" + name + "]";
	}

}
