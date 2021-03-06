package com.ojas.obs.controller;

import static com.ojas.obs.constants.Constants.DELETE;
import static com.ojas.obs.constants.Constants.GETBYID;
import static com.ojas.obs.constants.Constants.SAVE;
import static com.ojas.obs.constants.Constants.UPDATE;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.obs.facadeimpl.BudgetFacadeImpl;
import com.ojas.obs.model.Budget;
import com.ojas.obs.request.BudgetRequest;
import com.ojas.obs.response.ErrorResponse;

@RestController
public class BudgetController {
	@Autowired
	private BudgetFacadeImpl budgetfacadeImpl;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value = "/set")
	public ResponseEntity<Object> saveDetails(@RequestBody BudgetRequest budgetRequestObject,
			HttpServletRequest request, HttpServletResponse response) {
		logger.debug("data coming into controller");

		List<Budget> budget = budgetRequestObject.getBudgetList();

		try {
			if (budgetRequestObject.getBudgetList() == null || budget.isEmpty()) {
				ErrorResponse error = new ErrorResponse();
				error.setStatusCode("422");
				error.setStatusMessage("reqest object is null");
				return new ResponseEntity<Object>(error, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			for(Budget g:budget) {
			if (budgetRequestObject.getTransactionType().equalsIgnoreCase(SAVE)
					&&g.getBudget()==null) {
				ErrorResponse error = new ErrorResponse();
				error.setStatusCode("422");
				error.setStatusMessage(" Field is null");
				return new ResponseEntity<Object>(error, HttpStatus.UNPROCESSABLE_ENTITY);

			}

		
				if (budgetRequestObject.getTransactionType().equalsIgnoreCase(UPDATE)
						&& budgetRequestObject.getBudgetList().get(0).getBudget() == null
						|| budgetRequestObject.getTransactionType().equalsIgnoreCase(DELETE)
								&& budgetRequestObject.getBudgetList().get(0).getBudget() == null) {
					ErrorResponse error = new ErrorResponse();
					error.setStatusCode("422");
					error.setStatusMessage(" Field is null");
					return new ResponseEntity<Object>(error, HttpStatus.UNPROCESSABLE_ENTITY);

				}
			}
				return budgetfacadeImpl.saveDetails(budgetRequestObject);

			} catch (DuplicateKeyException e) {
				ErrorResponse error = new ErrorResponse();
				error.setStatusCode("409");
				error.setStatusMessage("duplicate key Exception");
				error.setStatusMessage(e.getCause().getLocalizedMessage());
				return new ResponseEntity<Object>(error, HttpStatus.CONFLICT);
			} catch (Exception e) {
				ErrorResponse error = new ErrorResponse();
				error.setStatusCode("409");
				error.setStatusMessage(e.getMessage());
				return new ResponseEntity<Object>(error, HttpStatus.CONFLICT);
			}
		}
	@PostMapping(value = "/get")
	public ResponseEntity<Object> getDetails(@RequestBody BudgetRequest budgetRequestObject,
			HttpServletRequest servletRequest, HttpServletResponse servletResponse) {

		try {
			if (budgetRequestObject == null || budgetRequestObject.getBudgetList() == null
					|| budgetRequestObject.getBudgetList().isEmpty() || budgetRequestObject.getTransactionType() == null
					|| budgetRequestObject.getTransactionType().isEmpty()) {
				ErrorResponse error = new ErrorResponse();
				error.setStatusCode("422");
				error.setStatusMessage("object is null");
				return new ResponseEntity<Object>(error, HttpStatus.UNPROCESSABLE_ENTITY);
			}

			if (budgetRequestObject.getTransactionType().equalsIgnoreCase(GETBYID)
					&& budgetRequestObject.getBudgetList().get(0).getId() == null) {
				logger.error("please provide id");
				ErrorResponse error = new ErrorResponse();
				error.setStatusCode("422");
				error.setStatusMessage("Type must be getAll");
				return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			return budgetfacadeImpl.getDetails(budgetRequestObject);
		} catch (Exception e) {
			logger.debug("inside catch block.***");
			ErrorResponse er = new ErrorResponse();
			er.setStatusCode("409");
			er.setStatusMessage(e.getMessage());
			return new ResponseEntity<>(er, HttpStatus.CONFLICT);
		}

	}

}
