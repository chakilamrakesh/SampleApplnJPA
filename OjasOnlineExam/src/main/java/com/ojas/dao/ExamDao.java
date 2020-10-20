package com.ojas.dao;

import java.util.List;
import java.util.Set;

import com.ojas.entity.Question;

public interface ExamDao {

	List<Question> getAllQuestions();

	List<Question> getQuestionsByTechnology(Question question);

	Question updateQuestion(Question question);

	Question addQuestion(Question question);

	public Question getQuestionById(int questionId);

	void deleteBatchQuestion(int[] integers);

	void deleteUserById(int id);
	
	List<Question> getQuestionByTechnology(String tech);

	Question updateStatusById(Question findUser);

	List<Question> getQuestionsByStatus(String status);

	void changeBatchStatus(int[] integers);

	List<Question> getQuestionsByTechStatus(Set<String> questionTech, String status);

	

}
