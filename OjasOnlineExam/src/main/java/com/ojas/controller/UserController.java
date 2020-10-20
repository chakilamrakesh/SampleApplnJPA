package com.ojas.controller;

import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ojas.entity.Notification;
import com.ojas.entity.Question;
import com.ojas.entity.Result;
import com.ojas.entity.TestEvalution;
import com.ojas.entity.UserDetails;
import com.ojas.service.AdminService;
import com.ojas.service.ExamService;
import com.ojas.service.UserService;
import com.ojas.service.impl.ExamServiceImpl;
import com.ojas.utility.ListOfQuestions;
import com.ojas.utility.MailService;

/**
 * 
 * @author kmahendra
 *
 */
@Controller
// @RequestMapping("/userController")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired(required = true)
	MailService mailService;

	@Autowired
	ExamService examService;

	@Autowired
	ExamServiceImpl examServiceImpl;

	@Autowired
	AdminService adminService;

	@GetMapping(value = "/testForm")
	public ModelAndView test() {
		System.out.println("i'm in test page");
		return new ModelAndView("test");
	}

	@GetMapping(value = "/regForm")
	public ModelAndView reg() {
		System.out.println("i'm in register page");
		return new ModelAndView("signup", "userRegForm", new UserDetails());
	}

	/*
	 * To view Login Page
	 */
	@GetMapping(value = "/loginPage")
	public ModelAndView add() {
		System.out.println("i'm in login Page");
		return new ModelAndView("login", "loginDetails", new UserDetails());
	}

	/*
	 * Register User
	 */
	@PostMapping(path = "/register", produces = "application/json")
	public UserDetails registerUser(@ModelAttribute("userRegForm") UserDetails details, BindingResult result,
			HttpServletRequest request) {
		System.out.println("i'm in controller");

		// HttpSession session = request.getSession(false);

		details.setRole("user");
		 Calendar calendar = Calendar.getInstance();
		 java.sql.Date dateOfRegister = new java.sql.Date(calendar.getTime().getTime());
		    details.setDateOfRegister(dateOfRegister);
		String userName = details.getUserName();
		BigInteger mobile = details.getMobile();
		String number = mobile.toString();
		String technology = details.getTechnology();

		String subName = userName.substring(0, 3);
		String subNum = number.substring(4, 7);
		String subTech = technology.substring(0, 3);

		String concat = subName.concat(subNum);
		String password = concat.concat(subTech);

		details.setPassword(password);

		UserDetails registerUser = userService.registerUser(details);

		System.out.println("Registered successfully..");
		mailService.sendEmail(details.getEmail(), "Ojas Exam",
				"Your registration successful.. Kindly login to give the exam with the following credentials: \n Email:"
						+ details.getEmail() + "   password:" + details.getPassword());

		// userService.
		if (registerUser.getUserName() != null) {
			Notification notification = null;
			notification = new Notification();
			notification.setUserName(registerUser.getUserName());
			String msg = "new User has created with the userName::" + registerUser.getUserName();
			notification.setMsg(msg);
			userService.notifyAdmin(notification);
		}

		return registerUser;
	}

	/*
	 * Get the User By Id
	 */
	@GetMapping(path = "/getUserById/{id}", produces = "application/json")
	public UserDetails getUserById(@PathVariable("id") int id) {
		UserDetails registerUser = userService.getUserById(id);
		return registerUser;
	}

	/*
	 * Get All Users
	 */
	@GetMapping(path = "/getAllUsers", produces = "application/json")
	public List<UserDetails> getUsers() {
		List<UserDetails> users = userService.getAllUsers();
		return users;
	}

	/*
	 * Update User
	 */
	@PutMapping(path = "/updateUser/{id}", produces = "application/json")
	public UserDetails updateUser(@PathVariable("id") int id, @RequestBody UserDetails details) {
		UserDetails updateUser = userService.updateUserById(id, details);
		return updateUser;

	}

	/*
	 * Delete User By ID
	 */
	@DeleteMapping(path = "/deleteUserById/{id}")
	public void deleteUserById(@PathVariable("id") int id) {
		UserDetails findUser = userService.getUserById(id);
		if (findUser != null) {
			userService.deleteUserById(id);
		} else {
			System.out.println("User is not exist");
		}
	}

	/*
	 * Deleted Users By Batch
	 */
	@DeleteMapping(path = "/deleteBatch/{multipleIds}")
	public void deleteBatch(@PathVariable String[] multipleIds) {
		Integer[] intarray = new Integer[multipleIds.length];
		int i = 0;
		for (String str : multipleIds) {
			intarray[i] = Integer.parseInt(str.trim());
			i++;
		}
		userService.deletebatchusers(intarray);

	}

	/*
	 * Login Authentication
	 */
	@PostMapping(value = "/userLoginPage", produces = "application/json")
	public ModelAndView userLogin(@ModelAttribute("loginDetails") UserDetails userLogin, HttpServletRequest request,
			HttpServletResponse response) {
		List<UserDetails> userdetails = userService.validateUserLogin(userLogin);

		ModelAndView modelAndView = new ModelAndView();

		if ((userdetails != null) && (!userdetails.isEmpty())) {
			for (UserDetails userDetails2 : userdetails) {
				if ((userDetails2.getRole().equals("user"))) {
					System.out.println("user_Home_Page");
					modelAndView.addObject(userLogin);

					HttpSession session = request.getSession(false);

					session.setAttribute("user", userLogin);
					String mail = userLogin.getEmail();

					session.setMaxInactiveInterval(30 * 60);
					Cookie userName = new Cookie("user", mail);
					response.addCookie(userName);

					modelAndView.setViewName("instruction");
				} else if (userDetails2.getRole().equals("admin")) {
					System.out.println("admin_Home_Page");
					modelAndView.addObject(userLogin);
					// session.setAttribute("admin", userDetails2);
					modelAndView.setViewName("adminHome");
				} else {
					System.out.println("user not exists");
					modelAndView.addObject(userdetails);
					modelAndView.setViewName("login");
				}
			}
		} else {
			System.out.println("user not exists");
			modelAndView.addObject(userdetails);
			modelAndView.setViewName("login");
		}
		return modelAndView;

	}
	@GetMapping(path = "/getAllNotifications", produces = "text/html")
	public ModelAndView getAllNotifications(HttpServletRequest request) {
		System.out.println("in Get all Notifications");
		ModelAndView model=new ModelAndView();
		List<Notification> list = userService.getAllNotifications();
		model.addObject("notificationList", list);
		model.setViewName("notify");
		return model;
	}

	// Test Page
	@GetMapping(path = "/getQuestionsForUserExam")
	public ModelAndView getQuestionsForUserExam(HttpServletRequest request, Model model,
			ListOfQuestions listOfQuestions) {

		String questionlevel = null;

		ArrayList<Question> questionLevelList = new ArrayList<>();

		System.out.println("getting questions for exam....");
		HttpSession session = request.getSession(false);
		if (session != null) {
			UserDetails userObj = (UserDetails) session.getAttribute("user");

			String email = userObj.getEmail();

			UserDetails user = userService.getUserByMail(email);

			session.setAttribute("userdetails", user);

			String tech = user.getTechnology();
			double experience = user.getExperience();

			List<Question> questionsList = examService.getQuestionByTech(tech);

			for (Question question : questionsList) {

				questionlevel = question.getQuestionlevel();

				if ((questionlevel.equalsIgnoreCase("FRESHER")) && (experience <= 1)) {

					questionLevelList.add(question);

				} else if ((questionlevel.equalsIgnoreCase("MEDIUM")) && ((experience > 1) && (experience <= 4))) {

					questionLevelList.add(question);

				} else if ((questionlevel.equalsIgnoreCase("EXPERT")) && (experience > 4)) {

					questionLevelList.add(question);

				}

			}

			listOfQuestions.setQuestionsList(questionLevelList);

			System.out.println("adding list of questions to pojo list......");

			if (questionsList.isEmpty()) {

				System.out.println("No questions to dispaly...");

			} else {

				// HttpSession questionsSession = request.getSession(false);

				session.setAttribute("questionsList", questionLevelList);

				request.setAttribute("questionslist", questionLevelList);

				model.addAttribute("questionslist", questionLevelList);

				System.out.println("Technology based questions are retrived.......");

			}
		}

		return new ModelAndView("userTestForm");
	}

	@RequestMapping(value = "/sessionInvalidate")
	public ModelAndView sessionInvalidate(HttpServletRequest request, Model model, HttpServletResponse response) {

		/*
		 * System.out.println("session invalidate Controller...."); HttpSession
		 * session=request.getSession(false); if(session!=null){
		 * session.invalidate();
		 * 
		 * //model.addAttribute("session", session); session=null; }
		 */

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				cookie.setMaxAge(0);
				System.out.println("Cookies are disabling...");
				response.addCookie(cookie);
			}
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			System.out.println("Session is invalidated...");
		}

		return new ModelAndView("logout");

	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView gettingUserTest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("i''m in result");
		int score = 0;

		List<TestEvalution> result = new ArrayList<>();
		int correct = 0;
		try {

			HttpSession session = request.getSession(false);

			UserDetails userObj = (UserDetails) session.getAttribute("userdetails");

			for (int i = 1; i <= 10; i++) {
				if (request.getParameter("question" + i + "_id") != null) {
					int ques_id = Integer.parseInt(request.getParameter("question" + i + "_id"));

					String option = request.getParameter("question" + i + "_option");

					int userId = userObj.getUserId();

					TestEvalution testResult = new TestEvalution();

					testResult.setUserId(userId);

					testResult.setQuestionId(ques_id);
					testResult.setUserSelectedOption(option);

					result.add(testResult);

				}

			}

			List<Question> questionsListForTest = (List<Question>) session.getAttribute("questionsList");

			for (TestEvalution testResult : result) {

				for (Question question : questionsListForTest) {
					if (testResult.getQuestionId() == question.getId()) {
						if (testResult.getUserSelectedOption() != null) {
							if (testResult.getUserSelectedOption().equalsIgnoreCase(question.getCorrectoption())) {
								score++;
							}
						}
					}

				}

			}
			System.out.println(score);
			Result report = new Result();
			int userid = userObj.getUserId();
			String technology = userObj.getTechnology();

			report.setScore(score);
			report.setUserId(userid);
			report.setTechnology(technology);
			Calendar calendar = Calendar.getInstance();
			Date dateOfExamination = new Date(calendar.getTime().getTime());
			report.setDateOfExamination(dateOfExamination);

			adminService.reports(report);
			// adminService.testResult(result);

		} catch (Exception e) {
			System.out.println("Quiz.java [Error] Exception");
			e.printStackTrace();

		}

		return new ModelAndView("logout");

	}

}
