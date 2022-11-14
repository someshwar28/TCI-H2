package com.yash.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.yash.model.Employee;
import com.yash.repository.EmployeeRepository;

@SpringBootTest(classes = {EmployeeServiceTest.class})
public class EmployeeServiceTest {
	
	@Mock
	EmployeeRepository employeeRepository;
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Test
	public void testSaveEmployeeObject() {
		Employee employee=new Employee();
		employee.setId(1);
		employee.setName("someshwar");
		employee.setDept("dev");
		employee.setAddress("pune");
		
		when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.saveEmployeeObject(employee)).isEqualTo(employee);
	}
	
	@Test
	public void testGetAllEmployeeObject() {
		List<Employee>employeeList=new ArrayList<>();
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
		employeeList.add(employee);
		employeeList.add(employee1);
		
		when(employeeRepository.findAll()).thenReturn(employeeList);
		assertThat(employeeService.getAllEmployeeObject()).isEqualTo(employeeList);
	}

}
