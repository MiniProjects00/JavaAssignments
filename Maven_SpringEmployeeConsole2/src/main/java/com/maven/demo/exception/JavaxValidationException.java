package com.maven.demo.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class JavaxValidationException extends ResponseEntityExceptionHandler {
	
	
	@Override		
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exp,
			HttpHeaders headers, HttpStatus status, WebRequest request)	{
	
		Map<String, String> errorMap = new HashMap<>();
		
		List<ObjectError> errorList = exp.getBindingResult().getAllErrors();
		
		errorList.stream().forEach((e) -> {
			String propertyName = ((FieldError)e).getField();
			String errorMsg = e.getDefaultMessage();
			
			errorMap.put(propertyName, errorMsg);
		});
		
		return new ResponseEntity<Object>(errorMap, HttpStatus.BAD_REQUEST);
	}
	
		
	@ExceptionHandler
	public ResponseEntity<Object> handleConstraintViolation( ConstraintViolationException exp, WebRequest request) {
		
		Map<String, String> errorMap = new HashMap<>();
		
		for (ConstraintViolation<?> violation : exp.getConstraintViolations()) {
			
			String errorField = violation.getPropertyPath().toString();
			String violationMessage = violation.getMessage();
			
			errorMap.put(errorField, violationMessage);
	    }
		
		 return new ResponseEntity<Object>(errorMap, HttpStatus.BAD_REQUEST);
	}
	
}