package com.accolite.au.hibernate.assignment;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private int sid;
	private String name;
	private int age;
	private float marks;
	@OneToMany
	private List<Expenses> exps;
	@OneToOne
	private Laptop ltp;
	public List<Expenses> getExps() {
		return exps;
	}
	public Laptop getLtp() {
		return ltp;
	}
	public void setLtp(Laptop ltp) {
		this.ltp = ltp;
	}
	public void setExps(List<Expenses> exps) {
		this.exps = exps;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}

}
