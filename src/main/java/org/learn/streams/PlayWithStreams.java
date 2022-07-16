package org.learn.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import org.learn.Emp;

public class PlayWithStreams {

	public static void main(String[] args) {
		List<Department> departments = new ArrayList<>(Data.departmentList());
		
		Map<Integer, Double> map = departments.stream().flatMap(dep -> dep.getStudents().stream())
				.collect(Collectors.toMap(Student::getId, Student::getFee, (t, u) -> t + u));
		
		System.out.println("toMap with BinaryOperator :" + map);
		System.out.println("<<<--------------------->>>");

		System.out.println("AnyMatch : "
				+ departments.stream().map(Department::getDeptName).anyMatch(s -> s.equalsIgnoreCase("eng")));
		System.out.println("<<<--------------------->>>");

		System.out.println("AllMatch : "
				+ departments.stream().map(Department::getDeptName).allMatch(s -> s.equalsIgnoreCase("eng")));
		System.out.println("<<<--------------------->>>");

		System.out.println("NoneMatch : "
				+ departments.stream().map(Department::getDeptName).noneMatch(s -> s.equalsIgnoreCase("tamil")));
		System.out.println("<<<--------------------->>>");

		// same applies for averagingInt, averagingLong
		double var = departments.stream().map(Department::getStudents).flatMap(List::stream)
				.collect(Collectors.averagingDouble(Student::getFee));
		System.out.println("AveragingDouble :" + var);
		System.out.println("<<<--------------------->>>");

		// sorting map based on value/key.
		Map<PlayWithStreams, String> mapToSort = new HashMap<>();
		mapToSort.put(new PlayWithStreams(), "d");
		mapToSort.put(new PlayWithStreams(), "e");
		mapToSort.put(new PlayWithStreams(), "c");
		mapToSort.put(new PlayWithStreams(), "a");
		mapToSort.put(new PlayWithStreams(), "b");

		System.out.println("Before sorting");
		System.out.println(mapToSort);

		Map<PlayWithStreams, String> sortedLinkedHashMap = mapToSort.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1,e2)->e2, LinkedHashMap::new));

		System.out.println("After sorting based on value");
		System.out.println(sortedLinkedHashMap);
		System.out.println("<<<--------------------->>>");

	}

	@Override
	public String toString() {
		return "PWS";
	}

}
