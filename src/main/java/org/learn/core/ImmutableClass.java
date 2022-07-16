package org.learn.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * What Is an Immutable Class in Java?
 * Immutable class means once the object of the class is created its fields cannot be modified or changed.
 * In Java, all the wrapper classes like Boolean, Short, Integer, Long, Float, Double, Byte,
 * Char, and String classes are immutable classes.
 * 
 * The class must be declared as final (So that child classes can’t be created)
 * Data members in the class must be declared as private (So that direct access
 * is not allowed) Data members in the class must be declared as final (So that
 * we can’t change the value of it after object creation) A parameterized
 * constructor should initialize all the fields performing a deep copy (So that
 * data members can’t be modified with object reference) Deep Copy of objects
 * should be performed in the getter methods (To return a copy rather than
 * returning the actual object reference) No setters (To not have the option to
 * change the value of the instance variable)
 * 
 * https://stackoverflow.com/questions/12306651/why-would-one-declare-an-immutable-class-final-in-java
 * 
 * 
 * @author hprakash
 *
 */
public final class ImmutableClass {

	private final String name ;
	private final int id;
	private final Map<String, Object> map;

	ImmutableClass(String name, int id, Map<String, Object> map) {
		this.id = id;
		this.name = name;
		// doing deep copy here, incase if the map passed here in constructor is
		// altered somewhere in code it
		// shouldn't affect our object's state.
		this.map = new HashMap<>();
		map.entrySet().forEach(entry -> this.map.put(entry.getKey(), entry.getValue()));
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public Map<String, Object> getMap() {
		// return new map copying all the values of actual map object of this
		// class.
		// this will prevent changing of state of our object.
		Map<String, Object> map = new HashMap<>();
		this.map.entrySet().forEach(entry -> map.put(entry.getKey(), entry.getValue()));
		return map;
	}

	@Override
	public String toString() {
		return "ImmutableClass [name=" + name + ", id=" + id + ", map=" + map + "]";
	}

	// test impl
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		ImmutableClass immutableClass = new ImmutableClass("ggg", 1, map);		
		System.out.println(immutableClass);
		immutableClass.getMap().put("key", "value");
		map.put("Key", "value");
		System.out.println(immutableClass);
	}

}
