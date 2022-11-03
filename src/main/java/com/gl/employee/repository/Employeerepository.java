package com.gl.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.employee.model.Employee;

@Repository
public interface Employeerepository extends JpaRepository<Employee, Long> {
	
	public List<Employee> findbyfirstname( String firstname);

}
