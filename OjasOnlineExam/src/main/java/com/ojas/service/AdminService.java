package com.ojas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ojas.entity.Contact;
import com.ojas.entity.FileBean;
import com.ojas.entity.Result;
import com.ojas.entity.TestEvalution;

/**
 * 
 * @author kmahendra
 *
 */
@Service
public interface AdminService {
	
	public void uploadExcelFile(FileBean fileBean);
	
	public void saveContactInfo(Contact contact);
	
	public List<TestEvalution> userTestQuestions(int id);
	
	
	public List<TestEvalution> getAllReports();

	public Result reports(Result report);
	
	
	
}
