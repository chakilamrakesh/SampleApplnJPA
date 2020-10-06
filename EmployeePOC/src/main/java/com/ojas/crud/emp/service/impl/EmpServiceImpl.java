package com.ojas.crud.emp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ojas.crud.emp.dao.EmpDao;
import com.ojas.crud.emp.model.Employee;
import com.ojas.crud.emp.pagination.EmployeePaginationResponse;
import com.ojas.crud.emp.reposnse.EmployeeResponse;
import com.ojas.crud.emp.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {

	EmployeeResponse employeeResponse = new EmployeeResponse();

	@Autowired
	private EmpDao empDao;

	@Override
	public EmployeeResponse getEmployeeById(int id) {

		List<Employee> empList = new ArrayList<>();
		try {

			Employee empById = empDao.findById(id);
			if (empById != null) {
				empList.add(empById);
				employeeResponse.setEmp(empList);
				employeeResponse.setStatusCode("200");
				employeeResponse.setStatusMessage("employee record fetched");
			} else {
				employeeResponse.setEmp(empList);
				employeeResponse.setStatusCode("200");
				employeeResponse.setStatusMessage("no records found");
			}
		} catch (Exception e) {
			employeeResponse.setStatusCode("422");
			employeeResponse.setStatusMessage(e.getMessage());

		}

		return employeeResponse;
	}

	@Override
	public EmployeeResponse createEmp(Employee employee) {

		try {
			Employee empSaveInfoFromDB = empDao.save(employee);
			List<Employee> emplist = new ArrayList<>();
			emplist.add(empSaveInfoFromDB);
			if (empSaveInfoFromDB != null) {
				employeeResponse.setEmp(emplist);
				employeeResponse.setStatusCode("200");
				employeeResponse.setStatusMessage("User created successfully");
				return employeeResponse;
			}
		} catch (Exception e) {
			String message = e.getMessage();
			if (message.contains("ConstraintViolationException")) {
				employeeResponse.setStatusCode("422");
				employeeResponse.setStatusMessage("user not created");
				return employeeResponse;
			} else {
				employeeResponse.setStatusCode("422");
				employeeResponse.setStatusMessage("user not created");
				return employeeResponse;
			}
		}
		return employeeResponse;
	}

	@Override
	public EmployeeResponse deleteEmpId(int id) {

		try {

			int deleteById = empDao.deleteById(id);

			if (deleteById > 0) {
				employeeResponse.setStatusCode("200");
				employeeResponse.setStatusMessage("employee deleted successfully");
			} else {
				employeeResponse.setStatusCode("422");
				employeeResponse.setStatusMessage("employee not found");
			}

		} catch (Exception e) {
			 employeeResponse.setStatusCode("200");
	         employeeResponse.setStatusMessage(e.getMessage());
	         return employeeResponse;
		}

		return employeeResponse;
	}

	@Override
	public Object getAllEmployees(int pageNo, int pageSize) {

		EmployeePaginationResponse employeePagResponse = new EmployeePaginationResponse();
		try {

			PageRequest pagination = PageRequest.of(pageNo, pageSize, Sort.by(Order.desc("id")));
			Page<Employee> empRecords = empDao.findAll(pagination);

			if (empRecords != null && !empRecords.isEmpty()) {
				employeePagResponse.setPageNo(empRecords.getNumber());
				employeePagResponse.setTotalRecords(empRecords.getNumberOfElements());
				employeePagResponse.setPageSize(empRecords.getSize());
				employeePagResponse.setEmp(empRecords.getContent());

			} else {

				employeePagResponse.setStatusCode("200");
				employeePagResponse.setStatusMessage("no records found");
			}

		} catch (Exception e) {

			String message = e.getMessage();
			if (message.contains("Page size must not be less than one")) {
				employeePagResponse.setStatusCode("422");
				employeePagResponse.setStatusMessage("please give page size in positive no's");
			}
		}

		return employeePagResponse;
	}

}
