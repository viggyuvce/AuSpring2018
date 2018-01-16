package com.au.spring.assignment;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import com.mysql.jdbc.*;
public class App {
	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("applicationContext.xml");  
	    EmployeeDao dao=(EmployeeDao)context.getBean("edao");  
	    Employee emp = (Employee)context.getBean("emp");
	    Employee emp1 = (Employee)context.getBean("emp1");
	    dao.saveEmployee(emp);  
	    dao.saveEmployee(emp1);
	    dao.deleteEmployee(1);
	}
}
