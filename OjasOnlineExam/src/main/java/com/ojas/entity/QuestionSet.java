package com.ojas.entity;

import java.io.Serializable;

/**
 * 
 * @author kmahendra
 *
 */
public class QuestionSet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int setId;
	private int questionId;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getSetId() {
		return setId;
	}

	public void setSetId(int setId) {
		this.setId = setId;
	}

}
