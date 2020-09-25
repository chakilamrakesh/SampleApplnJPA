package com.ojas.poc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.poc.dao.UserDao;
import com.ojas.poc.model.User;
import com.ojas.poc.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	public UserDao userDao;

	@Override
	public User createUser(User user) {

		User userData = userDao.save(user);
		return userData;
	}
	

}
