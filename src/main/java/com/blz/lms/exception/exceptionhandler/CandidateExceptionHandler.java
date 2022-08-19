package com.blz.lms.exception.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.blz.lms.exception.AdminNotFoundException;
import com.blz.lms.exception.CandidateNotFoundException;
import com.blz.lms.util.Response;

@ControllerAdvice
public class CandidateExceptionHandler {
	@ExceptionHandler(CandidateNotFoundException.class)
	public ResponseEntity<Response> handleHiringException(CandidateNotFoundException he){
		Response response=new Response();
		response.setErrorCode(400);
		response.setMessage(he.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}