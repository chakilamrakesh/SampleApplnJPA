package com.ojas.poc.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.poc.dao.JobDao;
import com.ojas.poc.helper.ExcelHelper;
import com.ojas.poc.model.Job;
import com.ojas.poc.service.JobService;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	public JobDao jobDao;

	@Override
	public Job createNewJob(Job job) {
		Job jobCreatedResponse = jobDao.save(job);
		return jobCreatedResponse;
	}

	@Override
	public List<Job> getJobByCountry(String jobByCOuntry) {
		List<Job> JobByCountry = jobDao.findJobByCountry(jobByCOuntry);
		return JobByCountry;
	}

	@Override
	public  List<Job> getJobByAvaialbility(String jobByAvaialbility) {
		List<Job> JobByAvaialbility = jobDao.findJobByAvaialbility(jobByAvaialbility);
		return JobByAvaialbility;
	}

	

	@Override
	public List<Job> getJobByLanguage(String jobByLanguage) {
		List<Job> findJobByLanguage = jobDao.findJobByLanguage(jobByLanguage);
		return findJobByLanguage;
	}

	@Override
	public List<Job> getJobByPayRate(String low,String high) {
		List<Job> findJobByPayRate = jobDao.findJobByPayRate(low,high);
		return findJobByPayRate;
	}

	@Override
	public Optional<Job> getJobById(long id) {
		Optional<Job> findById = jobDao.findById(id);
		return findById;
	}

	@Override
	public List<Job> getJobByType(String jobType) {
		List<Job> findJobByType = jobDao.findJobByType(jobType);
		return findJobByType;
	}

	@Override
	public List<Job> getJobByExperience(String exp) {
		List<Job> findJobByExperience = jobDao.findJobByExperience(exp);
		return findJobByExperience;
	}

	@Override
	public List<Job> getJobBySkills(String skillset) {
		List<Job> findJobBySkills = jobDao.findJobBySkills(skillset);
		return findJobBySkills;
	}

	public List<Job> getAllJobs(){
		List<Job> findAll = jobDao.findAll();
		return findAll;
		
	}

	@Override
	public void saveExcel(MultipartFile file) {

		try {
		      List<Job> savejob = ExcelHelper.excelToTutorials(file.getInputStream());
		      jobDao.saveAll(savejob);
		    } catch (IOException e) {
		      throw new RuntimeException("fail to store excel data: " + e.getMessage());
		    }
	}

}
