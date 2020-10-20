package com.ojas.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ojas.dao.ExamDao;
import com.ojas.entity.Question;

@Repository
public class ExamDaoImpl implements ExamDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public List<Question> getAllQuestions() {
		String sql = "select * from question";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public List<Question> getQuestionsByTechnology(Question question) {
		String sql = "select * from question where technology='" + question.getTechnology() + "'";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public Question addQuestion(Question question) {
		System.out.println("i'm in dao");
		String save = "insert into question(question,option1,option2,option3,option4,correctoption,technology,questiontype,questionlevel) "
				+ "values('" + question.getQuestion() + "','" + question.getOption1() + "','" + question.getOption2()
				+ "','" + question.getOption3() + "','" + question.getOption4() + "','" + question.getCorrectoption()
				+ "','" + question.getTechnology() + "','" + question.getQuestiontype() + "','"
				+ question.getQuestionlevel() + "')";
		jdbcTemplate.execute(save);
		return question;
	}

	@Override
	public Question updateQuestion(Question question) {
		String update = "update question set question='" + question.getQuestion() + "',option1='"
				+ question.getOption1() + "',option2='" + question.getOption2() + "',option3='" + question.getOption3()
				+ "'," + "option4='" + question.getOption4() + "',correctoption='" + question.getCorrectoption()
				+ "',technology='" + question.getTechnology() + "',questiontype='" + question.getQuestiontype()
				+ "',questionlevel='" + question.getQuestionlevel() + "' where id = " + question.getId() + "";
		jdbcTemplate.update(update);
		System.out.println("i'm in Dao Service");
		return question;
	}

	@Override
	public Question getQuestionById(int questionId) {
		String getById = "select * from question where id=?";
		return jdbcTemplate.queryForObject(getById, new Object[] { questionId },
				new BeanPropertyRowMapper<Question>(Question.class));

	}

	@Override
	public void deleteUserById(int id) {
		String deleteUser = "delete from question where id=?";
		jdbcTemplate.update(deleteUser, id);
		System.out.println("Deleted Record with ID = " + id);
	}

	@Override
	public void deleteBatchQuestion(int[] integers) {
		for (int i = 0; i < integers.length; i++) {
			if (integers.length > 0) {
				deleteUserById(integers[i]);
				System.out.println("user was deleted");
			} else {
				System.out.println("the delete was completed");
			}
		}

	}

	@Override
	public List<Question> getQuestionByTechnology(String tech) {

		String sql = "select * from question where technology='" + tech + "' and status='active' ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Question>(Question.class));	
	}

	@Override
	public Question updateStatusById(Question findUser) {
		String update = "update question set status='" + findUser.getStatus() + "' where id = " + findUser.getId() + "";
		jdbcTemplate.update(update);
		System.out.println("i'm in Dao Service");
		return findUser;
	}
	@Override
	public List<Question> getQuestionsByStatus(String status) {
		String sql = "select * from question where status='" + status + "'";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public void changeBatchStatus(int[] integers) {
		for (int i = 0; i < integers.length; i++) {
			if (integers.length > 0) {
				Question question = getQuestionById(integers[i]);
				if (question.getStatus().equals("active")) {
					question.setStatus("inactive");
					updateStatusById(question);
					System.out.println("status was changed");
				} else if (question.getStatus().equals("inactive")) {
					question.setStatus("active");
					updateStatusById(question);
				} 
				System.out.println("the status was changed");
			}
		}
	}

	@Override
	public List<Question> getQuestionsByTechStatus(Set<String> questionTech, String status) {
		int i=0;
		StringBuffer techStr = new StringBuffer();
		for (String string : questionTech) {
			
			techStr.append("SELECT * FROM question WHERE technology='");
			techStr.append(string);
			techStr.append("' and status='" + status + "'");
			if(i<questionTech.size()-1)
			{
					techStr.append(" "+"union"+ " ");
			}
			i++;			
		}
		System.out.println(techStr.toString());
		return jdbcTemplate.query(techStr.toString(), new BeanPropertyRowMapper<Question>(Question.class));
	}

}
