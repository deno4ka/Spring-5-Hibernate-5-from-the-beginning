package com.deno4ka.spring.crm.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponce> handleException(CustomerNotFoundException e) {
		CustomerErrorResponce error = new CustomerErrorResponce(
				HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis()
		);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponce> handleException(Exception e) {
		CustomerErrorResponce error = new CustomerErrorResponce(
				HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis()
		);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
