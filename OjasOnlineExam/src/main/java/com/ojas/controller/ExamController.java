package com.ojas.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ojas.entity.Question;
import com.ojas.service.ExamService;

/**
 * 
 * @author kmahendra
 *
 */
@Controller
@RequestMapping("/examController")
public class ExamController {

	@Autowired
	ExamService examService;

	@GetMapping(value = "active")
	public String msg() {
		System.out.println("i'm in login Page");
		return "msg";
	}

	@GetMapping(value = "questionsForm")
	public ModelAndView add() {
		System.out.println("i'm in login Page");
		return new ModelAndView("questions", "employee", new Question());
	}

	@GetMapping(value = "descriptiveForm")
	public ModelAndView descriptiveForm() {
		System.out.println("i'm in login Page");
		return new ModelAndView("descriptive", "employee", new Question());
	}

	@RequestMapping(value = "/getAllQuestions", method = RequestMethod.GET)
	public ModelAndView getAllQuestions(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("setemp");
		session.removeAttribute("inactive");
		session.removeAttribute("active");
		System.out.println("hiiiii");
		ModelAndView model = new ModelAndView();
		List<Question> listEmployee = examService.getAllQuestions();
		Set<String> setemp = new HashSet<String>();
		for (Question question : listEmployee) {
			String technology = question.getTechnology();
			setemp.add(technology);
		}
		System.out.println(setemp.size());
		session.setAttribute("getbytech", setemp);
		String first = "first";
		session.setAttribute("first", first);
		model.addObject("listEmployee", listEmployee);
		System.out.println("hii in getAllQuestions");
		model.setViewName("managequestions");

		return model;
	}

	@GetMapping(path = "/getQuestionsByTechnology")
	public ModelAndView questionsById(ModelAndView model, Question question, HttpServletRequest request) {
		Set<String> setTech = new HashSet<String>();
		HttpSession session=request.getSession();
		List<Question> listEmployee =examService.getQuestionsByTechnology(question);
		for (Question question2 : listEmployee) {
			String technology = question2.getTechnology();
			setTech.add(technology);
		}
	if (!listEmployee.isEmpty()) {
		session.setAttribute("getbytech", setTech);
		model.addObject("listEmployee", listEmployee);
		System.out.println("hii in getAllQuestionsByTechnology");
		model.setViewName("managequestions");
	} else {
		System.out.println("no data found with this technology....");
		model.setViewName("managequestions");
	}
		
		return model;
		}

	@RequestMapping(value = "/getQuestionsByStatusActive", method = RequestMethod.GET)
	public ModelAndView questionsByStatusActive(ModelAndView model, HttpServletRequest request) {
		String status = "active";
		HttpSession session = request.getSession();
		Set<String> questionTech = (Set<String>) session.getAttribute("getbytech");
		
		List<Question> listOfQuestions=new ArrayList<>();
		listOfQuestions=examService.getQuestionsByTechStatus(questionTech, status);
			
		if (!listOfQuestions.isEmpty()) {
			model.addObject("listEmployee", listOfQuestions);
			System.out.println("hii in getAllQuestionsByStatus");
			model.setViewName("managequestions");
		} else {
			System.out.println("No data found with this status....");
			model.setViewName("managequestions");
		}
		return model;
	}

	@RequestMapping(value = "/getQuestionsByStatusInactive", method = RequestMethod.GET)
	public ModelAndView questionsByStatusInactive(HttpServletRequest request, ModelAndView model) {
		String status = "inactive";
		HttpSession session = request.getSession();
		Set<String> questionTech = (Set<String>) session.getAttribute("getbytech");
		
		List<Question> listOfQuestions=new ArrayList<>();
		listOfQuestions=examService.getQuestionsByTechStatus(questionTech, status);
			
		if (!listOfQuestions.isEmpty()) {
			model.addObject("listEmployee", listOfQuestions);
			System.out.println("hii in getAllQuestionsByStatus");
			model.setViewName("managequestions");
		} else {
			System.out.println("No data found with this status....");
			model.setViewName("managequestions");
		}
		return model;
	}

	@RequestMapping(value = "/editQuestion", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request, ModelAndView model) {
		System.out.println("hii in editQuestion");
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Question question = examService.getQuestionById(employeeId);
		model.addObject("employee", question);
		if (question.getQuestiontype().equalsIgnoreCase("descriptive")) {
			model.setViewName("descriptive");
		} else {
			model.setViewName("questions");
		}

		return model;
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("employee") Question question, ModelAndView model) {
		question.setStatus("active");
		if (question.getId() == 0) { 
			if ((question.getOption1() == null) && (question.getOption2() == null) && (question.getOption3() == null)
					&& (question.getOption4() == null)) {
				question.setQuestiontype("descriptive");
			} else {
				question.setQuestiontype("multiple");
			}
			examService.addQuestion(question);
			model.setViewName("questions");
			return new ModelAndView("redirect:/examController/getAllQuestions");
		} else {
			if ((question.getOption1() == null) && (question.getOption2() == null) && (question.getOption3() == null)
					&& (question.getOption4() == null)) {
				question.setQuestiontype("descriptive");
			} else {
				question.setQuestiontype("multiple");
			}
			examService.updateQuestion(question);
			return new ModelAndView("redirect:/examController/getAllQuestions");
		}
	}

	@RequestMapping(value = "/changeStatus", method = RequestMethod.GET)
	public ModelAndView changeStatus(HttpServletRequest request, ModelAndView model) {
		int id = Integer.parseInt(request.getParameter("id"));
		Question findUser = examService.getQuestionById(id);
		String status = findUser.getStatus();
		if (status.equals("active")) {
			findUser.setStatus("inactive");
			examService.updateStatusById(findUser);
			model.setViewName("redirect:/examController/getAllQuestions?status=active");
		} else if (status.equals("inactive")) {
			findUser.setStatus("active");
			examService.updateStatusById(findUser);
			model.setViewName("redirect:/examController/getAllQuestions?status=inactive");
		}
		return model;
	}

	@RequestMapping(value = "/changeBatchStatus", method = RequestMethod.GET)
	public ModelAndView changeBatchStatus(HttpServletRequest request, ModelAndView model,HttpSession session) {
		
		System.out.println("listOfMap: "+session.getAttribute("listOfMap"));
		
		String[] selectedUsertIds = request.getParameterValues("selected");
		if (selectedUsertIds != null) {
			int[] integers = new int[selectedUsertIds.length];
			for (int i = 0; i < integers.length; i++) {
				integers[i] = Integer.parseInt(selectedUsertIds[i]);
			}
			
			examService.changeBatchStatus(integers);
			model.setViewName("redirect:/examController/getAllQuestions");
		} else {
			model.setViewName("redirect:/examController/getAllQuestions");
		}
		return model;
	}

	@RequestMapping(value = "/deleteQuestionId", method = RequestMethod.GET)
	public ModelAndView deleteUserById(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Question findUser = examService.getQuestionById(id);
		if (findUser != null) {
			examService.deleteUserById(id);
		} else {
			System.out.println("User is not exist");
		}
		return new ModelAndView("redirect:/examController/getAllQuestions");
	}

	@RequestMapping(value = "/deleteBatchQuestion", method = RequestMethod.GET)
	public ModelAndView deleteBatchQuestion(HttpServletRequest request, ModelAndView model) {
		System.out.println("method called");
		String[] selectedUsertIds = request.getParameterValues("selected");
		int[] integers = new int[selectedUsertIds.length];
		for (int i = 0; i < integers.length; i++) {
			integers[i] = Integer.parseInt(selectedUsertIds[i]);
		}
		for (int i = 0; i < integers.length; i++) {
			System.out.println(integers[i]);
		}
		examService.deleteBatchQuestion(integers);
		return new ModelAndView("redirect:/examController/getAllQuestions");
	}

	@GetMapping(value = "/questionType")
	public ModelAndView selectQuestionType() {
		System.out.println("i'm in login Page");
		return new ModelAndView("questiontype", "employee", new Question());
	}

	@RequestMapping(value = "/reports")
	public ModelAndView reports() {
		return new ModelAndView("report");

	}

	@RequestMapping(value = "/notification")
	public ModelAndView notifications() {
		return new ModelAndView("notifications");

	}

	@RequestMapping(value = "/contactUs")
	public ModelAndView contactUs() {
		return new ModelAndView("contact");

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
}
