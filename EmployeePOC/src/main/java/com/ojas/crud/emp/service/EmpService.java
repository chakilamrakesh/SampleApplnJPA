package com.ojas.crud.emp.service;

import com.ojas.crud.emp.model.Employee;
import com.ojas.crud.emp.reposnse.EmployeeResponse;



public interface EmpService {

	EmployeeResponse getEmployeeById(int id);

	EmployeeResponse createEmp(Employee employee);

	EmployeeResponse deleteEmpId(int id);
	
	Object getAllEmployees(int pageNo, int pageSize);
	
}
