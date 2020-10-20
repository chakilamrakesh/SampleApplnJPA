package com.ojas.entity;

import java.io.Serializable;

/**
 * 
 * @author kmahendra
 *
 */
public class Options implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int optionId;
	private int questionid;
	private String option1;
	private String option2;
	private String optaion3;
	private String option4;
	private String correctOption;

	public int getOptionId() {
		return optionId;
	}

	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}

	public int getQuestionid() {
		return questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOptaion3() {
		return optaion3;
	}

	public void setOptaion3(String optaion3) {
		this.optaion3 = optaion3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

}
