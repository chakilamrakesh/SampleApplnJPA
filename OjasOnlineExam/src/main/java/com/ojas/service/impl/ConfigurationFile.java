/*package com.ojas.service.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ojas.servlet.config.ConnectionPoolManager;

@Configuration
public class ConfigurationFile {

	public String DB_USERNAME;

	public String DB_PASSWORD;

	public String DB_URL;

	public String DRIVER_CLASS;

	public Integer DB_MAX_CONNECTIONS;

	public ConfigurationFile() {
		init();
	}

	private static ConfigurationFile configuration = new ConfigurationFile();

	public static ConfigurationFile getInstance() {
		return configuration;
	}

	private void init() {
		DRIVER_CLASS = "com.mysql.jdbc.Driver";
		DB_URL = "jdbc:mysql://localhost:3306/onlinedb";
		DB_USERNAME = "root";
		DB_PASSWORD = "root";
		DB_MAX_CONNECTIONS = 5;
	}

	@Bean
	public DriverManagerDataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(DRIVER_CLASS);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);

		System.out.println("data source.....");
		return dataSource;
	}

	ConnectionPoolManager con = new ConnectionPoolManager();

	@Bean
	public JdbcTemplate jdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		//con.initializeConnectionPool();
		jdbcTemplate.setDataSource(dataSource());
		System.out.println("Am in jdbcTemplate...");

		return jdbcTemplate;
	}
}
*/