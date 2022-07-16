package org.learn.streams;

public class Student {
	String name;
	int id;
	double fee;
	
	public Student(String name, int id, double fee) {
		super();
		this.name = name;
		this.id = id;
		this.fee = fee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", fee=" + fee + "]";
	}
	
	
}
