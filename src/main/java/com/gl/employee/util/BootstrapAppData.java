package com.gl.employee.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.employee.model.Employee;
import com.gl.employee.model.Role;
import com.gl.employee.model.User;
import com.gl.employee.repository.*;


import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class BootstrapAppData {
	
	private  Employeerepository employeeRepository;
	
	private  UserRepository userRepository;
	private  PasswordEncoder passwordEncoder;
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void insertEmployees(ApplicationReadyEvent event) {
		
		Employee santhosh = new Employee();
		santhosh.setFirstname("santhosh");
		santhosh.setLastname("kumar");
		santhosh.setEmail("santhosh@gmail.com");
		this.employeeRepository.save(santhosh);
		
		Employee suresh = new Employee();
		suresh.setFirstname("Suresh");
		suresh.setLastname("raj");
		suresh.setEmail("suresh@gmail.com");

		this.employeeRepository.save(suresh);
		
		User jana = new User();
		jana.setUsername("jana");
		jana.setPassword(this.passwordEncoder.encode("welcome"));
		jana.setEmailAddress("vinay@gmail.com");

		Role janaRole = new Role();
		janaRole.setRoleName("ADMIN");
		
		User kamal = new User();
		kamal.setUsername("kamal");
		kamal.setPassword(this.passwordEncoder.encode("welcome"));
		kamal.setEmailAddress("kamal@gmail.com");
		Role kamalRole = new Role();
		kamalRole.setRoleName("USER");

		kamal.addRole(kamalRole);
		
		this.userRepository.save(jana);
		this.userRepository.save(kamal);




		
	}
}

