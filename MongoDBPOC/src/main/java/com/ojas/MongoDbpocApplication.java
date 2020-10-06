package com.ojas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class MongoDbpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoDbpocApplication.class, args);
	}

}
