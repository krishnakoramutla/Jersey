package com.demo.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@Path("/api")
public class EmployeeResource {

	@Autowired
	private EmployeeDao dao;

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/add")
	public Employee savEmployee(Employee employee) {
		return dao.save(employee);
	}

	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/employees")
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	@GET
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/employees/{id}")
	public Employee getByIdEmployee(@PathParam("id") int id) {
		return dao.findById(id).get();
	}

	@DELETE
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/employees/del/{id}")
	public void deleteById(@PathParam("id") int id) {

		dao.deleteById(id);
	}

}
