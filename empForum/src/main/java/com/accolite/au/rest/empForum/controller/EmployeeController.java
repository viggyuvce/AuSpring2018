package com.accolite.au.rest.empForum.controller;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accolite.au.rest.empForum.model.Employee;
import com.accolite.au.rest.empForum.services.EmployeeService;

@Path("employees")
public class EmployeeController {
	static EmployeeService serviceObject = new EmployeeService();
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getAllEmployeeDetails(){
		return serviceObject.getAllEmployees();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee getEmployeeById(@PathParam("id")int id) {
		return serviceObject.getEmployeeById(id);
	}
	
	@POST
	@Path("/")
	@Produces(MediaType.TEXT_PLAIN)
	public String putEmployee(Employee emp) {
		return serviceObject.putEmployee(emp);
	}
	
	@PUT
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateEmployee(@PathParam("id")int id,float salary) {
		return serviceObject.updateEmployee(id,salary);
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployee(@PathParam("id")int id) {
		return serviceObject.deleteEmployee(id);
	}
	
}
