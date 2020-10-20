package com.ojas.service;

import java.util.List;

import com.ojas.entity.Notification;
import com.ojas.entity.UserDetails;

/**
 * 
 * @author kmahendra
 *
 */
public interface UserService {

	UserDetails registerUser(UserDetails details);

	UserDetails getUserById(int id);

	List<UserDetails> getAllUsers();

	UserDetails updateUserById(int id, UserDetails details);

	void deleteUserById(int id);

	void deletebatchusers(Integer[] intarray);

	List<UserDetails> validateUserLogin(UserDetails userLogin);

	List<UserDetails> searchUser(double exp);

	Notification notifyAdmin(Notification notification);

	List<Notification> getAllNotifications();
	
	
	//public List<Question> getQuestionsForExam();
	
	public UserDetails getUserByMail(String mail);
	
	

}
