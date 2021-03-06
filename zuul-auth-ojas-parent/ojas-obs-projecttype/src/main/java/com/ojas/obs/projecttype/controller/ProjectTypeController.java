package com.ojas.obs.projecttype.controller;

import static com.ojas.obs.projecttype.constants.Constants.DELETE;
import static com.ojas.obs.projecttype.constants.Constants.GET;
import static com.ojas.obs.projecttype.constants.Constants.GETBYID;
import static com.ojas.obs.projecttype.constants.Constants.SAVE;
import static com.ojas.obs.projecttype.constants.Constants.SET;
import static com.ojas.obs.projecttype.constants.Constants.UPDATE;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.obs.projecttype.facadeimpl.ProjectTypeFacadeImpl;
import com.ojas.obs.projecttype.model.ProjectType;
import com.ojas.obs.projecttype.request.ProjectTypeRequest;
import com.ojas.obs.projecttype.response.ErrorResponse;

@RestController
public class ProjectTypeController {
	@Autowired
	private ProjectTypeFacadeImpl facadeImpl;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping(SET)
	public ResponseEntity<Object> save(@RequestBody ProjectTypeRequest request) {
		logger.debug("request coming to the controller");
		try {
			List<ProjectType> list = request.getProjectTypeList();
			if (list == null) {
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setMessage("request is empty");
				errorResponse.setStatusCode("422");
				return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			for (ProjectType type : list) {
				if (request.getTransactionType() == null || request.getTransactionType().isEmpty()) {
					ErrorResponse errorResponse = new ErrorResponse();
					errorResponse.setMessage("transaction type is empty");
					errorResponse.setStatusCode("422");
					return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
				}
				if (request.getTransactionType().equalsIgnoreCase(SAVE) && 
						type.getProjectType().isEmpty()) {
					logger.debug("field is empty in save method");
					ErrorResponse errorResponse = new ErrorResponse();
					errorResponse.setMessage("field is empty in save method");
					errorResponse.setStatusCode("422");
					return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
				}
				if ((request.getTransactionType().equalsIgnoreCase(UPDATE)
						|| request.getTransactionType().equalsIgnoreCase(DELETE)) && type.getId() == null
						|| type.getStatus() == null) {
					logger.debug("id or status is null");
					ErrorResponse errorResponse = new ErrorResponse();
					errorResponse.setMessage("id or status is null");
					errorResponse.setStatusCode("422");
					return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
				}
			}
			return facadeImpl.saveDetails(request);
		} catch (DuplicateKeyException e) {
			logger.debug("DuplicateException");
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("DuplicateException");
			errorResponse.setStatusCode("409");
			errorResponse.setStatusMessage(e.getMessage());
			return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);

		} catch (Exception e) {
			logger.debug("Main Exception");
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("Exception is occured");
			errorResponse.setStatusCode("409");
			errorResponse.setStatusMessage(e.getMessage());
			return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
		}
	}

	@PostMapping(GET)
	public ResponseEntity<Object> getAllIssues(@RequestBody ProjectTypeRequest request) {
		logger.debug("request coming to the controller");
		try {
			if (request.getTransactionType() == null || request.getTransactionType().isEmpty()) {
				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setMessage("transaction type is empty");
				errorResponse.setStatusCode("422");
				return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			if (request.getTransactionType().equalsIgnoreCase(GETBYID) && request.getProjectTypeList().get(0).getId() == null) {

				ErrorResponse errorResponse = new ErrorResponse();
				errorResponse.setMessage("id is null in getbyid");
				errorResponse.setStatusCode("422");
				return new ResponseEntity<>(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			return new ResponseEntity<>(facadeImpl.getAllDetails(request),HttpStatus.OK);
		} catch (DuplicateKeyException e) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("DuplicateKeyException is occured");
			errorResponse.setStatusCode("409");
			errorResponse.setStatusMessage("DuplicateKeyException");
			return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
		} catch (Exception e) {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setMessage("Main Exception is occured");
			errorResponse.setStatusCode("409");
			errorResponse.setStatusMessage("Exception");
			return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
		}
	}
}
