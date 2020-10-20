package com.ojas.utility;

import java.util.List;

import com.ojas.entity.Question;

public class ListOfQuestions {

	private static final long serialVersionUID = 1L;

	private List<Question> questionsList;

	public ListOfQuestions() {

		super();

	}

	public List<Question> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<Question> questionsList) {
		this.questionsList = questionsList;
	}
}
