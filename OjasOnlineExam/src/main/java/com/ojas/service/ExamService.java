package com.ojas.service;

import java.util.List;
import java.util.Set;

import com.ojas.entity.Question;

public interface ExamService {

	List<Question> getAllQuestions();

	List<Question> getQuestionsByTechnology(Question question);

	Question addQuestion(Question question);
	void deleteUserById(int id);

	Question updateQuestion(Question question);

	Question getQuestionById(int employeeId);

	void deleteBatchQuestion(int[] integers);
	
	Question updateStatusById(Question findUser);

	List<Question> getQuestionsByStatus(String status);

	void changeBatchStatus(int[] integers);

	List<Question> getQuestionsByTechStatus(Set<String> questionTech, String status);

	public List<Question> getQuestionByTech(String tech);

	
}
