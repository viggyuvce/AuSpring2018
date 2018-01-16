package com.accolite.au.java.design.abstractFactory;

public class Football extends Product{
	public String size;

	public String getSize() {
		return size;
	}

	public Football(String brand2, float price2, String size) {
		super(brand2, price2);
		this.size = size;
	}

	
}
