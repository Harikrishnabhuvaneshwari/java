package org.learn.core;

import java.util.HashMap;
import java.util.Map;

public class EqualsAndHashCode {

	int id;
	String name;

	public EqualsAndHashCode(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public static void main(String[] args) {

		EqualsAndHashCode equalsAndHashCode = new EqualsAndHashCode(1, "priya");
		EqualsAndHashCode equalsAndHashCode2 = new EqualsAndHashCode(1, "priya");

		System.out.println(equalsAndHashCode.equals(equalsAndHashCode2));
		System.out.println(equalsAndHashCode.hashCode());
		System.out.println(equalsAndHashCode2.hashCode());

		Map<EqualsAndHashCode, String> map = new HashMap<>();
		map.put(equalsAndHashCode, "priya");
		map.put(equalsAndHashCode2, "paypal");
		
		System.out.println(map);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EqualsAndHashCode other = (EqualsAndHashCode) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
