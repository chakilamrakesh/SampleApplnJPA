package com.ojas.dao;

import java.util.List;

import com.ojas.entity.Notification;
import com.ojas.entity.UserDetails;

/**
 * 
 * @author kmahendra
 *
 */
public interface UserDao {

	UserDetails saveUser(UserDetails details);

	UserDetails getUserById(int id);

	List<UserDetails> getAllUsers();

	UserDetails updateUserById(int id, UserDetails details);

	void deleteUserById(int id);

	void deletebatchusers(Integer[] multipleIds);

	List<UserDetails> validateUserLogin(UserDetails userLogin);

	List<UserDetails> searchByUsers(double exp);

	Notification notifyAdmin(Notification notification);

	public List<Notification> getAllNotifications();
	
	public UserDetails getUserByMail(String mail);
	
	
	
}
