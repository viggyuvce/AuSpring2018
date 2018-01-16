package com.accolite.au.rest.empForum.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.accolite.au.rest.empForum.model.Employee;

public class EmployeeService {
	
	List<Employee> empList = new ArrayList<Employee>();
	
	public EmployeeService() {
		Employee e1=new Employee();
		e1.setId(1);
		e1.setName("Viggie");
		e1.setSalary(10000f);
		empList.add(e1);
	}
	public List<Employee> getAllEmployees(){
		return empList;
	}
	
	
	
	public Employee getEmployeeById(int id) {
		 return empList.stream().filter(p ->( p.getId() == id)).findAny().get();
		
	}
	
	public String putEmployee(Employee emp) {
		if(empList.stream().anyMatch(p->p.getId() == emp.getId())) {
			System.out.println("Given id is also taken by an employee");
			return "Employee already exists";
		}
		
		System.out.println("+++++Employee Details+++++++");
		System.out.println("Employee id:"+emp.getId());
		System.out.println("Employee name:"+emp.getName());
		System.out.println("Employee salary:"+emp.getSalary());
		empList.add(emp);
		return "inserted successfully";
	}
	
	public String deleteEmployee(int id) {
		empList.removeIf(p->p.getId() == id);
		return "removed employee if such an id was present";
	}
	
	public String updateEmployee(int id,float newSalary) {
		if(empList.size() >0) {
		List<Employee> emp1List = empList.stream().map(o -> {
			if(o.getId() == id) {
				o.setSalary(newSalary);
				return o;
			}
			else
				return o;
		}).collect(Collectors.toList());
		empList = emp1List;
		return "Successfully updated";
		}
		else {
			System.out.println("No such employee found");
			return "No employee found";
		}
	}
	
	
}
