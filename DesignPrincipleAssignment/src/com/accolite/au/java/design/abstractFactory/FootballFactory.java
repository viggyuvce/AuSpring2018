package com.accolite.au.java.design.abstractFactory;

public class FootballFactory extends Product implements SportsAbstractFactory {
	String size;

	public String getSize() {
		return size;
	}

	public FootballFactory(String brand2, float price2, String size) {
		super(brand2, price2);
		this.size = size;
	}

	@Override
	public Product createProduct() {
		// TODO Auto-generated method stub
		return new Football(brand,price,size);
	}
}
