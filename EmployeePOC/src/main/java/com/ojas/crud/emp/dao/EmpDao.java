package com.ojas.crud.emp.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ojas.crud.emp.model.Employee;

public interface EmpDao extends JpaRepository<Employee, Long >{

	Employee findById(int id);
	
	@Transactional
    @Modifying
    @Query(value = "update localhost.empcrud set status = '0' where emp_id = :id", nativeQuery = true)
	int deleteById(int id);
	
}
