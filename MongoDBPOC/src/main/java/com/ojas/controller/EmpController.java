package com.ojas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.bean.Employee;
import com.ojas.dao.EmployeeDao;

@RestController
@RequestMapping("/employee")
public class EmpController {

	@Autowired
	private EmployeeDao empdao;
	
	@PostMapping("/createEmp")
	public ResponseEntity<Object> createEmp(@RequestBody Employee emp) {
		Employee employee = empdao.save(emp);
		return new ResponseEntity<Object>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<Object> getAllEmp() {
		List<Employee> findAll = empdao.findAll();
		return new ResponseEntity<Object>(findAll,HttpStatus.OK);
	}
}
