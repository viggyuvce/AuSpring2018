package com.accolite.au.java.design.abstractFactory;

public class Ball extends Product {
	public String type;

	public Ball( String Brand, float price,String type) {
		super(Brand,price);
		this.type = type;
	}
	
	

	
}
