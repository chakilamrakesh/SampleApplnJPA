package com.ojas.obs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 
 * @author akrishna
 *
 */
@SpringBootApplication(scanBasePackages = "com.ojas.obs.*")
@EnableDiscoveryClient
public class BankDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankDetailsApplication.class, args);
	}

}
