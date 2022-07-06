package com.project.server.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.server.pojo.ExceptionResponse;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {
	@ExceptionHandler(ServerNotFound.class)
	public ResponseEntity<ExceptionResponse> handleExceptions1() {
		ExceptionResponse response = new ExceptionResponse();
		response.setLocalDateTime(LocalDateTime.now());
		response.setMessage(" Server Details Not Found");
		ResponseEntity<ExceptionResponse> entity = new ResponseEntity<ExceptionResponse>(response,
				HttpStatus.NOT_FOUND);
		return entity;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> handleExceptions() {
		ExceptionResponse response = new ExceptionResponse();
		response.setLocalDateTime(LocalDateTime.now());
		response.setMessage("Not found |Not valid");
		ResponseEntity<ExceptionResponse> entity = new ResponseEntity<ExceptionResponse>(response,
				HttpStatus.NOT_FOUND);
		return entity;
	}

}
