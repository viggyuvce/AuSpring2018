package com.accolite.java.streams;

import java.util.ArrayList;
import java.util.Random;

public class App {
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i=0; i<1000;++i) {
			list.add(rand.nextInt(1000));
		}
		list.stream().filter(p->p%5==0).forEach(p->System.out.println(p));
		
	}
	
		
}
