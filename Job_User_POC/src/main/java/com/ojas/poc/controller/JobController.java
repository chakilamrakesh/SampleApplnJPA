package com.ojas.poc.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ojas.poc.helper.ExcelHelper;
import com.ojas.poc.message.ResponseMessage;
import com.ojas.poc.model.Job;
import com.ojas.poc.service.JobService;

@RequestMapping(value="job" ,produces = { "application/json", "application/xml"} )
@RestController
public class JobController {

	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public JobService jobService;

	@RequestMapping("/postjob")
	public ResponseEntity<Job> createJob(@RequestBody Job job) {

		logger.info("Innnncoming request for JobController ::::");
		try {
			Job jobInfo = jobService.createNewJob(job);
			logger.debug(job);
			return new ResponseEntity<Job>(jobInfo, HttpStatus.CREATED);
		} catch (Exception e) {

			return new ResponseEntity<Job>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	@RequestMapping("/getjob/{id}")
	public ResponseEntity<Job> getJobByID(@PathVariable long id) {
		logger.info("calling getJobByID API");
		try {
			Optional<Job> jobDetailsById = jobService.getJobById(id);
			if (jobDetailsById.isPresent()) {
				logger.debug(jobDetailsById);
				return new ResponseEntity<Job>(jobDetailsById.get(), HttpStatus.OK);
			}
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Job>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	@RequestMapping("/getByType/{type}")
	public ResponseEntity<Object> getJobByType(@PathVariable String type) {

		try {
			List<Job> jobDetailsById = jobService.getJobByType(type);
			if (jobDetailsById != null) {

				return new ResponseEntity<Object>(jobDetailsById, HttpStatus.OK);
			}
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	@RequestMapping("/getByExp/{exp}")
	public ResponseEntity<Object> getJobByExperience(@PathVariable String exp) {
		logger.info("request in getJobByExperience");
		try {
			List<Job> jobDetailsByExp = jobService.getJobByExperience(exp);
			if (jobDetailsByExp != null) {

				return new ResponseEntity<Object>(jobDetailsByExp, HttpStatus.OK);
			}
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	@RequestMapping("/getByCountry/{country}")
	public ResponseEntity<Object> getJobByCountry(@PathVariable String country) {
		logger.info("request in getJobByCountry");
		try {
			List<Job> jobDetailsByCountry = jobService.getJobByCountry(country);
			if (jobDetailsByCountry != null) {

				return new ResponseEntity<Object>(jobDetailsByCountry, HttpStatus.OK);
			}
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	@RequestMapping("/getByAvailability/{availability}")
	public ResponseEntity<Object> getJobByAvailability(@PathVariable String availability) {
		logger.info("request in getJobByAvailability");
		try {
			List<Job> jobDetailsByCountry = jobService.getJobByAvaialbility(availability);
			if (jobDetailsByCountry != null) {

				return new ResponseEntity<Object>(jobDetailsByCountry, HttpStatus.OK);
			}
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	@RequestMapping("/getBySkills/{skills}")
	public ResponseEntity<Object> getJobBySkills(@PathVariable("skills") String skillset) {
		logger.info("request in getJobBySkills");
		try {
			List<Job> jobDetailsBySkills = jobService.getJobBySkills(skillset);
			if (jobDetailsBySkills != null) {

				return new ResponseEntity<Object>(jobDetailsBySkills, HttpStatus.OK);
			}
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	@RequestMapping("/getByLanguage/{language}")
	public ResponseEntity<Object> getJobByLanguage(@PathVariable String language) {
		logger.info("request in getJobByLanguage");
		try {
			List<Job> jobDetailsByLanguage = jobService.getJobByLanguage(language);
			if (jobDetailsByLanguage != null) {

				return new ResponseEntity<Object>(jobDetailsByLanguage, HttpStatus.OK);
			}
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping("/getByPayRate/{low}/{high}")
	public ResponseEntity<Object> getJobByPayrate(@PathVariable String low, @PathVariable String high) {

		List<Job> jobByPayRate = jobService.getJobByPayRate(low, high);
		if (jobByPayRate != null) {
			return new ResponseEntity<Object>(jobByPayRate, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}

	}
	
	@RequestMapping("/getalljobs")
	public ResponseEntity<Object> getAllJobs() {

		List<Job> getalljobs = jobService.getAllJobs();
		if (getalljobs != null) {
			return new ResponseEntity<Object>(getalljobs, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}

	}
	
	@PostMapping("/processjobexcel")
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file ) {
		String message="";
		if (ExcelHelper.hasExcelFormat(file)) {
		      try {
		    	  jobService.saveExcel(file);
		    	  message = "Uploaded the file successfully: " + file.getOriginalFilename();
		    	  return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		      }catch (Exception e) {
		    	 message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));  
		      }
		
		}
		return null;
	
}
	}
