package com.ojas.poc.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.poc.model.User;
import com.ojas.poc.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {
	
	Logger logger = Logger.getLogger(this.getClass()); 

	@Autowired
	public UserService userService;
	
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		try {
			User userData = userService.createUser(user);
			logger.debug("incoming requests " + user);
			if (userData != null) {

				return new ResponseEntity<User>(userData, HttpStatus.CREATED);
			}
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
