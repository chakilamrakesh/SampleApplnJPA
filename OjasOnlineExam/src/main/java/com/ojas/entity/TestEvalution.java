package com.ojas.entity;

import java.io.Serializable;

/**
 * 
 * @author kmahendra
 *
 */
public class TestEvalution implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;
	private String userSelectedOption;
	private int questionId;
	

	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getUserSelectedOption() {
		return userSelectedOption;
	}

	public void setUserSelectedOption(String userSelectedOption) {
		this.userSelectedOption = userSelectedOption;
	}

	

}
