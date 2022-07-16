package org.learn.streams;

import java.util.Arrays;
import java.util.List;

public class Data {

	public static List<Department> departmentList(){
		Student student1 = new Student("Student1", 1, 100.00);
		Student student2 = new Student("Student2", 2, 30.00);
		Student student3 = new Student("Student3", 3, 45.00);
		Student student4 = new Student("Student4", 4, 67.00);
		Student student5 = new Student("Student5", 5, 55.00);
		
		List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
		
		Department phy = new Department("Phy", students);
		Department chem = new Department("Chem", students);
		Department eng = new Department("Eng", students);
		
		return Arrays.asList(phy, chem, eng);
		
	}

}
