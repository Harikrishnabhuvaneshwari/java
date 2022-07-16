package org.learn.core;

class Model extends PriyaImmutable {

	String name;

	public Model(String name) {
		super(name);
		this.name = name;
	}

	@Override
	public String toString() {
		return "Model [name=" + name + "]";
	}

}
