package com.ojas.poc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.ojas.poc.model.Job;

public interface JobService {

	public Job createNewJob(Job job);
	
	public Optional<Job> getJobById(long id);
	
	public List<Job> getJobByType(String jobType);
	
	
	public List<Job> getJobByExperience(String exp);
	
	public List<Job> getJobByCountry(String country);
	
	public  List<Job> getJobByAvaialbility(String availability);
	
	public List<Job> getJobBySkills(String skillset);
	
	public List<Job> getJobByLanguage(String language);
	
	public List<Job> getJobByPayRate(String low,String high);

	public List<Job> getAllJobs();

	
	public void saveExcel(MultipartFile file);
	
}
