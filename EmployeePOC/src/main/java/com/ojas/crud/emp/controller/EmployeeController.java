package com.ojas.crud.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.crud.emp.model.Employee;
import com.ojas.crud.emp.pagination.EmployeePaginationResponse;
import com.ojas.crud.emp.reposnse.EmployeeResponse;
import com.ojas.crud.emp.service.EmpService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
	private EmpService empService ;

	@Autowired
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	EmployeeResponse employeeResponse = new EmployeeResponse();

	@GetMapping("/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable int id) {

		if(id>=1) {
		
			EmployeeResponse employeeResponse = empService.getEmployeeById(id);
			return new ResponseEntity<Object>(employeeResponse, HttpStatus.OK);
		
		}else {
			
			employeeResponse.setStatusCode("400");
			employeeResponse.setStatusMessage("invalid request");
			return new ResponseEntity<Object>(employeeResponse,HttpStatus.BAD_REQUEST);
		}


	}

	@PostMapping("/createEmp")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee) {

		if (employee.getName() != null && !employee.getName().isEmpty() && employee.getCity() != null
				&& employee.getSal() >= 0 && employee.getPhone() >= 0) {

			EmployeeResponse empCreatedInfo = empService.createEmp(employee);

			return new ResponseEntity<Object>(empCreatedInfo, HttpStatus.CREATED);

		} else {
			employeeResponse.setStatusMessage("invalid request");
			employeeResponse.setStatusCode("422");
			return new ResponseEntity<Object>(employeeResponse, HttpStatus.UNPROCESSABLE_ENTITY);

		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteEmployeeById(@PathVariable int id) {

		if(id>0) {
			EmployeeResponse deleteEmpId = empService.deleteEmpId(id);
			return new ResponseEntity<Object>(deleteEmpId,HttpStatus.OK);
		}else {
			employeeResponse.setStatusMessage("invalid request");
			employeeResponse.setStatusCode("422");
			return new ResponseEntity<Object>(employeeResponse, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	@GetMapping("/getAll/{pageNo}/{pageSize}")
	public ResponseEntity<Object> getAllEmployees(@PathVariable int pageNo,@PathVariable int pageSize) {

		if(pageNo>=1 && pageSize>=1) {
			Object employeesList = empService.getAllEmployees(pageNo,pageSize);
			
			return new ResponseEntity<Object>(employeesList, HttpStatus.OK);
		}else {
			EmployeePaginationResponse empPagResponse=new EmployeePaginationResponse();
			if(pageNo<=0 || pageSize<=0) {
				empPagResponse.setStatusCode("422");
				empPagResponse.setStatusMessage("Please give page no and page size in postive no's");
			}else {
			empPagResponse.setStatusCode("400");
			empPagResponse.setStatusMessage("invalid request");
			}
			return new ResponseEntity<Object>(empPagResponse,HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping("/userlogin")
    public String userValidation() {
		
        return "User: Successfully logged in!";

    }

    @RequestMapping("/adminlogin")
    public String adminValidation() {
        return "Admin: Successfully logged in!";

    }
}
