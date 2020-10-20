package com.ojas.servlet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * 
 * @author kmahendra
 *
 */
@Configuration
// @PropertySource("classpath:db.properties")
public class AppConfig {

	/*
	 * Properties props = new Properties(); 
	 * FileInputStream fis = null;
	 */

	/*
	 * @Autowired 
	 * Environment props;
	 */

	public String DB_USERNAME;

	public String DB_PASSWORD;

	public String DB_URL;

	public String DRIVER_CLASS;

	public Integer DB_MAX_CONNECTIONS;

	public AppConfig() {
		init();
	}

	//private static AppConfig configuration = new AppConfig();

	public static AppConfig getInstance() {
		return new AppConfig();
	}

	private void init() {
		DRIVER_CLASS = "com.mysql.jdbc.Driver";
		DB_URL = "jdbc:mysql://localhost:3306/onlinedb";
		DB_USERNAME = "root";
		DB_PASSWORD = "root";
		DB_MAX_CONNECTIONS = 5;
	}
	//ConnectionPoolManager con = new ConnectionPoolManager();
	@Bean
	public JdbcTemplate jdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		//con.initializeConnectionPool();
		jdbcTemplate.setDataSource(driverManagerDataSource());
		System.out.println("Am in jdbcTemplate...");
		return jdbcTemplate;
	}

	@Bean
	public DriverManagerDataSource driverManagerDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.getConnectionProperties();
		dataSource.setDriverClassName(DRIVER_CLASS);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);

		System.out.println("data source.....");
		return dataSource;

	}
	
	

	 @Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSizePerFile(20 * 1024 * 1024);// 20mb
		System.out.println("Mutlipart file");
		return resolver;

	}


	/*
	 * @Bean public MessageSource source(){ ResourceBundleMessageSource
	 * resourceBundleMessageSource = new ResourceBundleMessageSource();
	 * resourceBundleMessageSource.addBasenames("db"); return
	 * resourceBundleMessageSource; }
	 */
}
