package com.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	/*
	 * void saveEmployee(Employee employee); void updateEmployee(Employee employee);
	 * void deleteEmployee(Employee employee);
	 */
	//List<Employee> getEmployeesData(Employee employee);
}
