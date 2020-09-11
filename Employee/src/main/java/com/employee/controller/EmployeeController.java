package com.employee.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;

@RestController
@CrossOrigin(origins = "http://localhost:7071")
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping(value = "/getEmployee/{id}", consumes   = {"application/json"},produces =  {"application/xml"})
	
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {

		Optional<Employee> employeeData = employeeRepository.findById(id);

		if (employeeData.isPresent()) {
			return new ResponseEntity<>(employeeData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/createEmployee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {

		try {
			Employee employee2 = employeeRepository.save(new Employee(employee.getEmpId(), employee.getEmpAge(),
					employee.getEmpSalary(), employee.getEmpName()));
			return new ResponseEntity<>(employee2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	 @DeleteMapping("/deleteEmployee/{id}")
	  public ResponseEntity<HttpStatus> deleteEmployees(@PathVariable("id") long id) {
	    try {
	     employeeRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
