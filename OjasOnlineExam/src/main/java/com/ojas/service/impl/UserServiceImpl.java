package com.ojas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.UserDao;
import com.ojas.entity.Notification;
import com.ojas.entity.UserDetails;
import com.ojas.service.UserService;

/**
 * 
 * @author kmahendra
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails registerUser(UserDetails details) {
		System.out.println("i'm in servlce");
		UserDetails saveUser = userDao.saveUser(details);
		return saveUser;
	}

	@Override
	public UserDetails getUserById(int id) {
		UserDetails saveUser = userDao.getUserById(id);
		return saveUser;
	}

	@Override
	public List<UserDetails> getAllUsers() {
		List<UserDetails> saveUser = userDao.getAllUsers();
		return saveUser;
	}

	@Override
	public UserDetails updateUserById(int id, UserDetails details) {
		UserDetails saveUser = userDao.updateUserById(id, details);
		return saveUser;
	}

	@Override
	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}

	@Override
	public void deletebatchusers(Integer[] multipleIds) {
		userDao.deletebatchusers(multipleIds);

	}

	@Override
	public List<UserDetails> validateUserLogin(UserDetails userLogin) {
		return userDao.validateUserLogin(userLogin);
	}

	@Override
	public List<UserDetails> searchUser(double exp) {
		List<UserDetails> searchByUsers = userDao.searchByUsers(exp);
		return searchByUsers;
	}

	@Override
	public Notification notifyAdmin(Notification notification) {
		return userDao.notifyAdmin(notification);
	}

	@Override
	public List<Notification> getAllNotifications() {
		
		
		return userDao.getAllNotifications();
	}

	

	@Override
	public UserDetails getUserByMail(String mail) {

		
		return userDao.getUserByMail(mail);
	}

}
