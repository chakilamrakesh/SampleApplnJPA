package com.ojas.crud.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ojas.crud.emp.*"})
public class EmployeePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePocApplication.class, args);
	}

}
