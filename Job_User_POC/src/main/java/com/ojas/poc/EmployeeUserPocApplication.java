package com.ojas.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class EmployeeUserPocApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeUserPocApplication.class, args);
	}

}
