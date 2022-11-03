package com.gl.employee.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employee.model.Employee;
import com.gl.employee.repository.Employeerepository;

@Service
public class EmployeeService {
	
	@Autowired
	private Employeerepository employeerepository;
	public void employeeservice(Employeerepository employeerepository)
	{
		this.employeerepository= employeerepository;
	}
	
	public Employee addemployee(Employee employee)
	{
		System.out.println("saving employee ");
		Employee savedemployee= this.employeerepository.save(employee);
		return savedemployee;
	}
	
	public Set<Employee> fetchAllEmployees(){
		return new HashSet<>(this.employeerepository.findAll());
		
	}
	
	public Employee fetchEmployeebyId(long employeeId)
	{
		return this.employeerepository
				.findById(employeeId)
		        .orElseThrow(()-> new IllegalArgumentException("invalid employee id"));
		           
     }
	
	public void deleteEmployeebyId(long employeeId)
	{
		this.employeerepository.deleteById(employeeId);
	}

	public Employee updateemployee(long emplloyeeid, Employee employee) {
		
	Employee repositoryemployee =	this.fetchEmployeebyId(emplloyeeid);
	repositoryemployee.setEmail(employee.getEmail());
	repositoryemployee.setFirstname(employee.getFirstname());
	repositoryemployee.setLastname(employee.getLastname());
	return this.employeerepository.save(repositoryemployee);
		
		
	}
	

		
		
	
	

}
