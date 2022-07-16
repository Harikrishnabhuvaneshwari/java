package org.learn.core;

public final class PriyaImmutable {
	
	private final String name;
	
	public PriyaImmutable(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		
		PriyaImmutable priyaImmutable = new PriyaImmutable("Priya");
		
		Model model = new Model("PriyaKumar");
		
		PriyaImmutable priyaImmutable2 = model;
		
		System.out.println(priyaImmutable2);
		
		model.name = "KumarPriya";
		
		
		System.out.println(priyaImmutable2);

	}

	@Override
	public String toString() {
		return "PriyaImmutable [name=" + name + "]";
	}
}
