package com.ojas.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.ojas.dao.UserDao;
import com.ojas.entity.Notification;
import com.ojas.entity.UserDetails;

/**
 * 
 * @author kmahendra
 *
 */
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String ADMIN_NOTIFICATION_QRY = "INSERT INTO NOTIFICATION VALUES(?,?,?)";
	private static final String GET_ALL_NOTIFICATIONS_QRY = "SELECT ID,USERNAME,MSG FROM NOTIFICATION";

	// register the users
	@Override
	public UserDetails saveUser(UserDetails details) {
		System.out.println("i'm in dao");
		String save = "insert into userdetails(username,gender,technology,experience,qualification,email,mobile,uid,address,password,dob,role,dateOfRegister) "
				+ "values('" + details.getUserName() + "','" + details.getGender() + "','" + details.getTechnology()
				+ "','" + details.getExperience() + "','" + details.getQualification() + "','" + details.getEmail()
				+ "','" + details.getMobile() + "','" + details.getUid() + "','" + details.getAddress() + "','"
				+ details.getPassword() + "','" + details.getDob() + "','" + details.getRole() + "','"
				+ details.getDateOfRegister() + "')";
		jdbcTemplate.execute(save);
		return details;
	}

	// get user by id
	@Override
	public UserDetails getUserById(int id) {
		String getById = "select * from userdetails where userid=?";
		return jdbcTemplate.queryForObject(getById, new Object[] { id },
				new BeanPropertyRowMapper<UserDetails>(UserDetails.class));

	}

	// get all the users
	@Override
	public List<UserDetails> getAllUsers() {
		String sql = "select * from userdetails";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
	}

	// update the users
	@Override
	public UserDetails updateUserById(int id, UserDetails details) {
		String update = "update userdetails set username='" + details.getUserName() + "',gender='" + details.getGender()
				+ "',technology='" + details.getTechnology() + "'," + "experience='" + details.getExperience()
				+ "',qualification='" + details.getQualification() + "',email='" + details.getEmail() + "',"
				+ "mobile='" + details.getMobile() + "',uid='" + details.getUid() + "',address='" + details.getAddress()
				+ "'," + "password='" + details.getPassword() + "',dob='" + details.getDob() + "',role='"
				+ details.getRole() + "',dateOfRegister='" + details.getDateOfRegister() + "' where userid = " + id
				+ "";
		jdbcTemplate.execute(update);
		return details;
	}

	// delete by id
	@Override
	public void deleteUserById(int id) {
		String deleteUser = "delete from userdetails where userid=?";
		jdbcTemplate.update(deleteUser, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	// delete by batch
	@Override
	public void deletebatchusers(Integer[] multipleIds) {
		for (int i = 0; i < multipleIds.length; i++) {
			deleteUserById(multipleIds[i]);
			System.out.println("user was deleted");
		}

	}

	// validate user login
	@Override
	public List<UserDetails> validateUserLogin(UserDetails userLogin) {
		ArrayList<UserDetails> valid = new ArrayList<UserDetails>();
		List<UserDetails> allUsers = getAllUsers();
		for (UserDetails userDetails2 : allUsers) {
			if (userLogin.getEmail().equalsIgnoreCase(userDetails2.getEmail())
					&& (userLogin.getPassword().equalsIgnoreCase(userDetails2.getPassword()))) {
				valid.add(userDetails2);
				return valid;
			}

		}

		String sql = "SELECT * from  userdetails WHERE email = ? and password=?";

		String email = userLogin.getEmail();
		String password = userLogin.getPassword();

		try {

			UserDetails userdetails = jdbcTemplate.queryForObject(sql, new Object[] { email, password },
					new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		return valid;
	}
	// search user

	public List<UserDetails> searchByUsers(double exp) {
		// List<UserDetails> listUsers = new ArrayList<UserDetails>();
		String sql = "select * from userdetails where experience =" + exp;
		List<UserDetails> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
		return list;
	}

	@Override
	public Notification notifyAdmin(Notification notification) {

		int cnt = jdbcTemplate.update(ADMIN_NOTIFICATION_QRY, notification.getId(), notification.getUserName(),
				notification.getMsg());
		return notification;
	}

	// get all notifications
	@Override
	public List<Notification> getAllNotifications() {
		return jdbcTemplate.query(GET_ALL_NOTIFICATIONS_QRY, new ResultSetExtractor<List<Notification>>() {

			@Override
			public List<Notification> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Notification> notificationList = new ArrayList<>();
				while (rs.next()) {
					Notification notification = new Notification();
					notification.setId(rs.getInt(1));
					notification.setUserName(rs.getString(2));
					notification.setMsg(rs.getString(3));
					notificationList.add(notification);
				}
				return notificationList;
			}

		});
	}

	

	@Override
	public UserDetails getUserByMail(String mail) {

		String getByMail = "select * from userdetails where email=?";
		return jdbcTemplate.queryForObject(getByMail, new Object[] { mail },
				new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
		
			
	}
	
	
	
}
