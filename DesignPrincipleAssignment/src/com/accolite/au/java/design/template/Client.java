package com.accolite.au.java.design.template;

public class Client {
	public static void main(String[] args) {
		Home woodhouse = new WoodenHome();
		Home glasshouse = new GlassHome();
		
		woodhouse.buildHome();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
		
		glasshouse.buildHome();
	}
}
