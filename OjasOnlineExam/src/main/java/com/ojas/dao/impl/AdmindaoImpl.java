package com.ojas.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ojas.dao.AdminDao;
import com.ojas.entity.Contact;
import com.ojas.entity.FileBean;
import com.ojas.entity.Result;
import com.ojas.entity.TestEvalution;

/**
 * 
 * @author sdileep
 *
 */

@Repository
public class AdmindaoImpl implements AdminDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Integer uploadExcel(FileBean fileBean) throws IOException {

		ByteArrayInputStream bis = new ByteArrayInputStream(fileBean.getFileBean().getBytes());
		Workbook workbook;
		Sheet sheet;
		try {

			if (fileBean.getFileBean().getOriginalFilename().endsWith("xls")) {
				workbook = new HSSFWorkbook(bis);
				sheet = workbook.getSheetAt(0);

			} else if (fileBean.getFileBean().getOriginalFilename().endsWith("xlsx")) {
				workbook = new XSSFWorkbook(bis);
				sheet = workbook.getSheetAt(0);

			} else {
				throw new IllegalArgumentException("Received file does not have a standard excel extension.");
			}

			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();

			StringBuilder sql = new StringBuilder();
			sql.append(
					"Insert into  question (question, technology, option1, option2, option3, option4, correctoption,questiontype,questionlevel) values");

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				Iterator<Cell> cellIterator = row.cellIterator();

				sql.append("(");

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					sql.append("'");
					sql.append(cell.getStringCellValue());
					sql.append("'");
					sql.append(",");
				}
				sql.deleteCharAt(sql.length() - 1);
				sql.append(")");

				sql.append(",");

			}

			sql.deleteCharAt(sql.length() - 1);
			String finalQuery = sql.toString();

			jdbcTemplate.execute(finalQuery);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return 0;
	}

	public void saveContactInfo(Contact contact) {

		String save = "insert into contact(name,email,subject,message) " + "values('" + contact.getName() + "','"
				+ contact.getEmail() + "','" + contact.getSubject() + "','" + contact.getMessage() + "')";
		jdbcTemplate.execute(save);

	}

	/*
	 * public void saveTestResult(List<Question> result) {
	 * 
	 * String save = "insert into test(userid,questionid,userselectedoption) " +
	 * "values('" + ((TestResult) result).getUserId() + "','" + ((TestResult)
	 * result).getQuestionId() + "','" + ((TestResult) result).getScore()+ "')";
	 * jdbcTemplate.execute(save);
	 * 
	 * }
	 */
	
	/*
	 * @Override public void testResult(List<TestEvalution> testResult) {
	 * 
	 * Iterator<TestEvalution> itr = testResult.iterator();
	 * 
	 * while (itr.hasNext()) {
	 * 
	 * TestEvalution result = itr.next();
	 * 
	 * insertResult(result); 
	 * }
	 */

	/*
	 * String save = "insert into test(userid,questionid,userselectedoption) " +
	 * "values('" + ((TestResult) result).getUserId() + "','" + ((TestResult)
	 * result).getQuestionId() + "','" + ((TestResult)
	 * result).getUserSelectedOption()+ "')"; jdbcTemplate.execute(save); }
	 */

	public void insertResult(TestEvalution result) {

		String query = "insert into test(userid,questionid,userselectedoption) " + "values('" + result.getUserId()
				+ "','" + result.getQuestionId() + "','" + result.getUserSelectedOption() + "')";
		jdbcTemplate.execute(query);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TestEvalution> userTestQuestions(int id) {

		String query = "select * from reports where id=?";

		return (List<TestEvalution>) jdbcTemplate.queryForObject(query, new Object[] { id },
				new BeanPropertyRowMapper<TestEvalution>(TestEvalution.class));
	}

	@Override
	public List<TestEvalution> getAllReports() {

		String query = "select * from reports";

		return jdbcTemplate.query(query, new BeanPropertyRowMapper<TestEvalution>(TestEvalution.class));

	}

	@Override
	public Result reports(Result report) {
		System.out.println("i'm in dao");
		String save = "insert into reports(userid,technology,score,dateOfExamination) " + "values('"
				+ report.getUserId() + "','" + report.getTechnology() + "','" + report.getScore() + "','"
				+ report.getDateOfExamination() + "')";
		jdbcTemplate.execute(save);
		return report;
	}

}
