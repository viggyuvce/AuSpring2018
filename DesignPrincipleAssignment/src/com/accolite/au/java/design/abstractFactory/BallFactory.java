package com.accolite.au.java.design.abstractFactory;

public class BallFactory extends Product implements SportsAbstractFactory {
	String type;
	public String getType() {
		return type;
	}
	public BallFactory(String brand, float price, String type) {
		super(brand,price);
		this.type = type;
	}
	public Product createProduct() {
		return new Ball(brand,price,type);
	}
	
}
