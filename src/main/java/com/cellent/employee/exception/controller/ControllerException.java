package com.cellent.employee.exception.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cellent.employee.exception.errordetails.ErrorDetails;


@RestControllerAdvice
public class ControllerException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> somethingWentWrong(Exception e)
	{
		
		ErrorDetails body=new ErrorDetails(e.toString());
		return new ResponseEntity<ErrorDetails>(body, new HttpHeaders(),HttpStatus.BAD_REQUEST );
	}

}
