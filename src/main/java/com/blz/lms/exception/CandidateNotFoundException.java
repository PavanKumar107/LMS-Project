package com.blz.lms.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class CandidateNotFoundException extends RuntimeException{
	private int statusCode;
	private String statusMessage;
	public CandidateNotFoundException(int statusCode, String statusMessage) {
		super(statusMessage);
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}
}