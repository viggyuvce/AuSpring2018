package crud;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface="crud.crudService")
public class EmployeeList implements crudService {
	ArrayList<Employee> list = new ArrayList<Employee>();
	
	@Override
	public String add(String id, String name, String designation,String salary) {
		Employee obj = new Employee();
		obj.id = id;
		obj.name = name;
		obj.designation = designation;
		obj.salary = salary;
		list.add(obj);
		return "Inserted "+name+" successfull";
	}
	public String remove(String id) {
		Employee emp;
		for(Employee e: list) {
			if(e.id.equals(id)) {
				emp = e;
				list.remove(e);
				return ("Removed "+emp.name+" successfully");
			}
		}
		return ("Error while removing");
	}
	public String getName(String id) {
		for(Employee e: list) {
			if(e.id.equals(id)) {
				return ("Name "+e.name);
			}
		}
		return "Not found";
	}
	public String update(String id,String newSalary) {
		for(Employee e: list) {
			if(e.id.equals(id)) {
				e.salary = newSalary;
				return ("The updated salary of "+e.name+"is "+e.salary);
			}
		}
		return "Not found";
	}
	
	
}
 