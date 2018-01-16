package com.accolite.au.java.design.abstractFactory;

public class Client {
	public static void main(String[] args) {	
		Product ball = ProductFactory.getProduct(
				new BallFactory("Reebok",(float) 78.0,"Leather"));
		Product bat = ProductFactory.getProduct(
				new BatFactory("Nike",(float)5000,4));
		System.out.println("Bat config");
		System.out.println("Brand: "+ball.brand);
		System.out.println("Price: "+ball.price);
		System.out.println("Ball config");
		System.out.println("Brand: "+bat.brand);
		System.out.println("Price: "+bat.price);
	}
}
