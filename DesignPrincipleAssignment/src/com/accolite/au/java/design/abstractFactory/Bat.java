package com.accolite.au.java.design.abstractFactory;

public class Bat extends Product{
	public float length;
	public float getLength() {
		return length;
	}
	public Bat(String brand, float price, float length) {
		super(brand,price);
		this.length = length;
	}
}
