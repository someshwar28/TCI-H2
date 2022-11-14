package com.yash.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.yash.model.Employee;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepoTest {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void testSaveEmployeeObjectOverRepository() {
		Employee employee=new Employee();
		employee.setName("someshwar");
		employee.setDept("dev");
		employee.setAddress("pune");
		
		employeeRepository.save(employee);
		
		assertThat(employee.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void testAllEmployeeObject() {
		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("someshwar");
		employee.setDept("dev");
		employee.setAddress("pune");
		
		Employee employee1=new Employee();
		employee1.setId(2);
		employee1.setName("mahesh");
		employee1.setDept("dev");
		employee1.setAddress("mumbai");
		
		employeeRepository.save(employee);
		employeeRepository.save(employee1);
		
		List<Employee> findAll = employeeRepository.findAll();
		assertThat(findAll.size()).isGreaterThan(0);
	}
}
