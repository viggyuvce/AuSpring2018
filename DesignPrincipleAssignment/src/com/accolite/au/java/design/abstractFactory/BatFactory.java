package com.accolite.au.java.design.abstractFactory;

public class BatFactory extends Product implements SportsAbstractFactory{
	float length;
	public float getLength() {
		return length;
	}
	public BatFactory(String brand, float price, float length) {
		super(brand,price);
		this.length = length;
	}
	@Override
	public Product createProduct() {
		// TODO Auto-generated method stub
		return new Bat(brand,price,length);
	}
}
