package com.gl.employee.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.employee.service.EmployeeService;
import com.gl.employee.model.Employee;

@RestController
@RequestMapping("/emp")
public class EmployeerestController {
	
	@Autowired
	private  EmployeeService employeeservice;
	
	public void EmployeeRestController(EmployeeService employeeservice)
	{
		this.employeeservice=employeeservice;
	}
	
	@GetMapping
	public Set<Employee> fetchallEmployees()
	{
		return this.employeeservice.fetchAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee employee(@PathVariable("id") long emplloyeeid )
	{
		return this.employeeservice.fetchEmployeebyId(emplloyeeid);
	}
	
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return this.employeeservice.addemployee(employee);
	}
	
    @DeleteMapping("/{id}")
    public void deleteemployee(@PathVariable("id") long emplloyeeid)	
    {
    	this.employeeservice.deleteEmployeebyId(emplloyeeid);
    }
    
    @PutMapping("/{id}")
    public Employee updateEmployee( @PathVariable("id") long emplloyeeid , @RequestBody Employee employee)
	{
		return this.employeeservice.updateemployee(emplloyeeid,employee);
	} 
 
   
}
    
    
