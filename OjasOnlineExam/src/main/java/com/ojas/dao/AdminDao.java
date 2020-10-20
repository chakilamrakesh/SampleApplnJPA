package com.ojas.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ojas.entity.Contact;
import com.ojas.entity.FileBean;
import com.ojas.entity.Result;
import com.ojas.entity.TestEvalution;

@Repository
public interface AdminDao {

	public Integer uploadExcel(FileBean fileBean) throws IOException;
	
	
	public void saveContactInfo(Contact contact);
	
	public List<TestEvalution> userTestQuestions(int id);
	
	
   public List<TestEvalution>  getAllReports();


   public Result reports(Result report);
   
}
