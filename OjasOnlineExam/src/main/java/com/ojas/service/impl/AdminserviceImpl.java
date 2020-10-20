package com.ojas.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.dao.AdminDao;
import com.ojas.entity.Contact;
import com.ojas.entity.FileBean;
import com.ojas.entity.Result;
import com.ojas.entity.TestEvalution;
import com.ojas.service.AdminService;

/**
 * 
 * @author sdileep
 *
 */
@Service
public class AdminserviceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public void uploadExcelFile(FileBean fileBean) {

		System.out.println("i'm in Admin servlce");

		try {
			adminDao.uploadExcel(fileBean);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void saveContactInfo(Contact contact) {

		adminDao.saveContactInfo(contact);
	}

	@Override
	public List<TestEvalution> userTestQuestions(int id) {
		
		return adminDao.userTestQuestions(id);
		
	}
	

	@Override
	public List<TestEvalution> getAllReports() {
		return adminDao.getAllReports();
	}

	@Override
	public Result reports(Result report) {
		return adminDao.reports(report);
	}

}
