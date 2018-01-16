package com.accolite.au.java.design.abstractFactory;

public class HockeyStickFactory extends Product implements SportsAbstractFactory {
	String type;

	public String getType() {
		return type;
	}

	public HockeyStickFactory(String brand2, float price2, String type) {
		super(brand2, price2);
		this.type = type;
	}

	@Override
	public Product createProduct() {
		// TODO Auto-generated method stub
		return new HockeyStick(brand,price,type);
	}

	
}
