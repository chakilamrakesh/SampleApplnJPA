package com.ojas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ojas.entity.Contact;
import com.ojas.entity.FileBean;
import com.ojas.entity.Notification;
import com.ojas.entity.Question;
import com.ojas.entity.TestEvalution;
import com.ojas.entity.UserDetails;
import com.ojas.service.AdminService;
import com.ojas.service.UserService;

//@RestController
/**
 * 
 * @author kmahendra
 *
 */

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@Autowired
	UserService userService;

	@GetMapping(path = "/getAllUsersByAdmin")
	public ModelAndView allUsers(Model model) {

		List<UserDetails> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return new ModelAndView("user");
	}

	@RequestMapping(value = "/delete/{id}")
	public ModelAndView deleteUser(@ModelAttribute("user") UserDetails user, @PathVariable("id") int id) {
		userService.deleteUserById(id);

		return new ModelAndView("delete");
	}

	// @PutMapping(value = "/edit/{id}")

	List<UserDetails> list;

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployee(@ModelAttribute("user") UserDetails editUser, @PathVariable("id") int id,
			Model model1) {
		System.out.println("am from edit page....");
		model1.addAttribute("data", new UserDetails());
		ModelAndView model = new ModelAndView("edit");

		list = new ArrayList<UserDetails>();
		editUser = userService.getUserById(id);
		list.add(editUser);

		model.addObject("user", editUser);

		return model;
	}

	@PostMapping(value = "/edit/save")
	public ModelAndView registerUser(@Validated UserDetails details) {
		System.out.println("i'm admin controller");
		for (UserDetails userDetails : list) {
			int userId = userDetails.getUserId();
			UserDetails userDetails2 = userService.getUserById(userId);
			userDetails2.setUserName(details.getUserName());
			userDetails2.setGender(details.getGender());
			userDetails2.setTechnology(details.getTechnology());
			userDetails2.setExperience(details.getExperience());
			userDetails2.setQualification(details.getQualification());
			userDetails2.setEmail(details.getEmail());
			userDetails2.setMobile(details.getMobile());
			userDetails2.setUid(details.getUid());
			userDetails2.setAddress(details.getAddress());
			userDetails2.setPassword(details.getPassword());
			userDetails2.setDob(details.getDob());
			userService.updateUserById(userId, userDetails2);
		}
		return new ModelAndView("save");
	}

	@RequestMapping(value = "/getUserById/{id}")
	public ModelAndView editEmployee(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("userbyid");

		UserDetails userById = userService.getUserById(id);

		model.addObject("user", userById);

		return model;
	}

	@RequestMapping(value = "/reports")
	public ModelAndView reports(HttpServletRequest request) {
		
		List<TestEvalution> allReports = adminService.getAllReports();
		
	//	userService.getUserByMail(mail)
		
		for(TestEvalution result:allReports){
			
			System.out.println(result);
		}
		
		
		return new ModelAndView("report");

	}

	@RequestMapping(value = "/notification")
	public ModelAndView notifications() {
		return new ModelAndView("notifications");

	}

	@RequestMapping(value = "/contactUs")
	public ModelAndView contactUs() {
			System.out.println("am from contact....");
		return new ModelAndView("contact");

	}
	
	
	@PostMapping(value="/saveContactInfo")
	public ModelAndView saveContact(@ModelAttribute("contactinfo") Contact contact,BindingResult result){
		System.out.println("saving contact info....");
		adminService.saveContactInfo(contact);
		
		
		if (contact.getName() != null) {
			Notification notification = null;
			notification = new Notification();
			notification.setUserName(contact.getName());
			String msg = "new User Dropped an Email::" + contact.getName();
			notification.setMsg(msg);
			userService.notifyAdmin(notification);
		}
		return new ModelAndView("redirect:index.jsp");
		
	}

	@RequestMapping(value = "/services")
	public ModelAndView services() {
		return new ModelAndView("services");

	}

	@RequestMapping(value = "/about")
	public ModelAndView aboutUs() {
		return new ModelAndView("about");

	}

	@RequestMapping(value = "dashboard")
	public ModelAndView dashboard() {
		return new ModelAndView("adminHome");

	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("index");

	}

	@RequestMapping(value = "/getUsersByDetails")
	public String searchUser(Model model, UserDetails user) {
		System.out.println("searchUser.************");
		double experience = user.getExperience();
		if (experience == 0) {
			return "invalid";
		}
		List<UserDetails> listOfUsers = userService.searchUser(experience);
		model.addAttribute("userlist", listOfUsers);
		return "userlist";

	}
	// ExcelFileUpload

	@RequestMapping(value = "/importFile", method = RequestMethod.GET)
	public ModelAndView importexcel()

	{

		ModelAndView model = new ModelAndView("importFile");

		FileBean fileBean = new FileBean();
		model.addObject("fileBean", fileBean);

		return model;

	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUpload(@ModelAttribute("fileBean") FileBean uploadItem, BindingResult result) {
		System.out.println(" In upload method");
		if (result.hasErrors()) {
			System.out.println("validation errors");

			return "importFile";
		} else {
			adminService.uploadExcelFile(uploadItem);

			return "redirect:/examController/getAllQuestions";
		}
	}
	
		
	@RequestMapping(value="getTestResult",method=RequestMethod.GET)
	public ModelAndView testResult(HttpServletRequest request){
	
        HttpSession session = request.getSession(false);
		
		UserDetails userObj = (UserDetails) session.getAttribute("user");
				
		List<Question> questionsFotTest = (List<Question>) session.getAttribute("questionsList");
			
		int userId = userObj.getUserId();
		
		for(Question qestion:questionsFotTest){
			
		}
		return null;
		
	}
	
	
	
	

}
