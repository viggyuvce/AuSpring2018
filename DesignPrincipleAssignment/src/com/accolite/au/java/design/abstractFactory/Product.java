package com.accolite.au.java.design.abstractFactory;

public abstract class Product {
	String brand;
	float price;
	
	public String getBrand() {
		return brand;
	}

	public float getPrice() {
		return price;
	}
	public Product(String brand, float price) {
		this.brand = brand;
		this.price = price;
	}
	
}
