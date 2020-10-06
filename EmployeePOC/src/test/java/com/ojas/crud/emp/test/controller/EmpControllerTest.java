package com.ojas.crud.emp.test.controller;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.ojas.crud.emp.controller.EmployeeController;
import com.ojas.crud.emp.model.Employee;
import com.ojas.crud.emp.reposnse.EmployeeResponse;
import com.ojas.crud.emp.service.EmpService;

@RunWith(MockitoJUnitRunner.class)
public class EmpControllerTest {

	@InjectMocks
	private EmployeeController employeeController;

	@Mock
	private EmpService empService;
	
	@Spy
	private EmployeeResponse employeeResponse;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	public List<Employee> getEmployee() {
		return null;
		
	}
}
