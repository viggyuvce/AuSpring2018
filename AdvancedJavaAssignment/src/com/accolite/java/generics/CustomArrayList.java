package com.accolite.java.generics;

import java.util.Arrays;

public class CustomArrayList<T> {
	private T arrayList [];
	private int size;
	@SuppressWarnings("unchecked")
	public CustomArrayList() {
		arrayList = (T[]) new Object[10];
		this.size = 0;

	}
	@SuppressWarnings("unchecked")
	public CustomArrayList(int size) {
		arrayList = (T[]) new Object[size];
		this.size = 0;
	}
	
	public void add(T element) {
		if(this.size == arrayList.length) {
			this.arrayList = Arrays.copyOf(this.arrayList,this.arrayList.length + 10);
		}
		arrayList[size] = element;
		this.size++;
	}
	
	public void remove(int index) {
		for(int i = index+1;i<size;++i) {
			arrayList[i-1] = arrayList[i];
		}
		this.size--;
	}
	public void display() {
		for(int i=0;i<size;++i)
			System.out.println(arrayList[i]);
	}
}
