package com.accolite.au.java.design.abstractFactory;

public class ProductFactory {
	public static Product getProduct(SportsAbstractFactory factory) {
		return factory.createProduct();
	}
}
