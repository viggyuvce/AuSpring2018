package com.accolite.java.generics;

public class App {
	
	public static void main(String[] args) {
		CustomArrayList<Integer> list = new CustomArrayList<Integer>();
		for(int i=0;i<100;++i) list.add(i);
		System.out.println("Current status of list");
		list.display();
		list.remove(2);
		System.out.println("Current status of list");
		list.display();
	}
}
