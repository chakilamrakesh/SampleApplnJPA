package com.ojas.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.ExamDao;
import com.ojas.entity.Question;
import com.ojas.service.ExamService;
@Service
public class ExamServiceImpl implements ExamService {

	@Autowired 
	ExamDao examDao;
	
	/*@Override
	public List<Question> getAllQuestions() {
		return examDao.getAllQuestions();
	}

	@Override
	public List<Question> getQuestionsByTechnology(Question question) {
		
		return examDao.getQuestionsByTechnology(question);
	}

	@Override
	public Question addQuestion(Question question) {
		return examDao.addQuestion(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		System.out.println("i'm in update Service");
		return examDao.updateQuestion(question);
	}

	@Override
	public Question getQuestionById(int questionId) {
		return examDao.getQuestionById(questionId);
	}

	@Override
	public void deleteBatchQuestion(int[] integers) {
		 examDao.deleteBatchQuestion(integers);
		
	}

	@Override
	public void deleteUserById(int id) {
		examDao.deleteUserById(id);
		
	}

	@Override
	public Question updateStatusById(Question findUser) {
		return examDao.updateStatusById(findUser);
	}

	@Override
	public List<Question> getQuestionsByStatus(String status) {
		return examDao.getQuestionsByStatus(status);
	}

	@Override
	public void changeBatchStatus(int[] integers) {
		 examDao.changeBatchStatus(integers);
		
	}

	@Override
	public List<Question> getQuestionsByTechStatus(Set<String> questionTech, String status) {
		
		return examDao.getQuestionsByTechStatus(questionTech, status) ;
	}*/
	
	@Override
	public List<Question> getAllQuestions() {
		return examDao.getAllQuestions();
	}

	@Override
	public List<Question> getQuestionsByTechnology(Question question) {

		return examDao.getQuestionsByTechnology(question);
	}

	@Override
	public Question addQuestion(Question question) {
		return examDao.addQuestion(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		System.out.println("i'm in update Service");
		return examDao.updateQuestion(question);
	}

	@Override
	public Question getQuestionById(int questionId) {
		return examDao.getQuestionById(questionId);
	}

	@Override
	public void deleteBatchQuestion(int[] integers) {
		examDao.deleteBatchQuestion(integers);

	}

	@Override
	public void deleteUserById(int id) {
		examDao.deleteUserById(id);

	}

	@Override
	public List<Question> getQuestionByTech(String tech) {

		return examDao.getQuestionByTechnology(tech);
	}
	
	@Override
	public Question updateStatusById(Question findUser) {
		return examDao.updateStatusById(findUser);
	}
	
	@Override
	public List<Question> getQuestionsByStatus(String status) {
		return examDao.getQuestionsByStatus(status);
	}
	
	@Override
	public void changeBatchStatus(int[] integers) {
		 examDao.changeBatchStatus(integers);
		
	}
	
	@Override
	public List<Question> getQuestionsByTechStatus(Set<String> questionTech, String status) {
		
		return examDao.getQuestionsByTechStatus(questionTech, status) ;
	}
}
