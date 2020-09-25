package com.ojas.poc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ojas.poc.model.Job;

@Repository
public interface JobDao extends JpaRepository<Job, Long> {

	@Query(value = "select * from job where job_type = ?1", nativeQuery = true)
	List<Job> findJobByType(String jobType);

	List<Job> findJobByExperience(String exp);

	List<Job> findJobByCountry(String jobByCountry);

	@Query(value = "select * from job where availability = ?1", nativeQuery = true)
	List<Job> findJobByAvaialbility(String jobByAvaialbility);

	@Query(value = "select * from job where skills like %?1%", nativeQuery = true)
	List<Job> findJobBySkills(String skillset);

	List<Job> findJobByLanguage(String language);

	@Query(value = "select * from job where pay_rate BETWEEN ?1 AND ?2", nativeQuery = true)
	List<Job> findJobByPayRate(String low, String high);
	
	List<Job> findAll();
	
	
}
