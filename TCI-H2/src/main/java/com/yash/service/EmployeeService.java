package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.model.Employee;
import com.yash.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee saveEmployeeObject(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployeeObject(){
		return employeeRepository.findAll();
	}

}
