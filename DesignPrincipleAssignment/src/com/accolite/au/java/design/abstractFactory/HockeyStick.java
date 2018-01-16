package com.accolite.au.java.design.abstractFactory;

public class HockeyStick extends Product {
	public String type;

	public String getType() {
		return type;
	}

	public HockeyStick(String brand2, float price2, String type) {
		super(brand2, price2);
		this.type = type;
	}

	

}
