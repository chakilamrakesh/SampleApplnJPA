package com.ojas.entity;

import java.io.Serializable;

/**
 * 
 * @author kmahendra
 *
 */
public class Question implements Serializable {

	private static final long serialVersionUID = -3465813074586302847L;

	private int id;

	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctoption;
	private String technology;
	private String questiontype;
	private String questionlevel;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectoption() {
		return correctoption;
	}

	public void setCorrectoption(String correctoption) {
		this.correctoption = correctoption;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	public String getQuestionlevel() {
		return questionlevel;
	}

	public void setQuestionlevel(String questionlevel) {
		this.questionlevel = questionlevel;
	}

}
