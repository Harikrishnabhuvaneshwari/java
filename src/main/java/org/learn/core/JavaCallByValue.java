package org.learn.core;

public class JavaCallByValue extends Object  {

	String name;

	public JavaCallByValue(String name) {
		super();
		this.name = name;
	}

	public static void main(String[] args) {
		JavaCallByValue test = new JavaCallByValue("priyaaa");
		change(test);
		System.out.println(test);
	}

	static void change(JavaCallByValue test) {
		System.out.println(test);
		test.setName("indi");
		test = new JavaCallByValue("meena");
		System.out.println(test);
		test.setName("west");
		System.out.println(test);
	}

	@Override
	public String toString() {
		return "Test [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
