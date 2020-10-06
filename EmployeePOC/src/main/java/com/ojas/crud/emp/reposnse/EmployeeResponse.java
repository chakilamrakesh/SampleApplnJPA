package com.ojas.crud.emp.reposnse;

import java.util.List;

import com.ojas.crud.emp.model.Employee;


public class EmployeeResponse {

	private String statusMessage;
	private String statusCode;
	private List<Employee> emp;

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public List<Employee> getEmp() {
		return emp;
	}

	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}

}
