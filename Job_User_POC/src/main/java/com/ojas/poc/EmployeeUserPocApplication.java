package com.ojas.poc;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class EmployeeUserPocApplication {
	static Logger logger = Logger.getLogger(EmployeeUserPocApplication.class);
	public static void main(String[] args) {
		logger.info("JobUserPOC application  entry started");
		SpringApplication.run(EmployeeUserPocApplication.class, args);
	}

}
