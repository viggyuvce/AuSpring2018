package com.accolite.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Student{
	int rollnum();
	String name();
	double percentage();
}

@Student(rollnum=1,name="Ram",percentage=89.90)
class students {
	int rollunum;
	String name;
	double percentage;
	public int getRollunum() {
		return rollunum;
	}
	public void setRollunum(int rollunum) {
		this.rollunum = rollunum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
}

public class App {
	public static void main(String[] args) {
		
		students s= new students();
		Class cls = s.getClass();
		
		Student stuAno = (Student) cls.getAnnotation(Student.class);
		System.out.println(stuAno.name());
	}
}
