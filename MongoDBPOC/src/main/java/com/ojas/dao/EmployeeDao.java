package com.ojas.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ojas.bean.Employee;

@Repository
public interface EmployeeDao extends MongoRepository<Employee, Long> {

}
