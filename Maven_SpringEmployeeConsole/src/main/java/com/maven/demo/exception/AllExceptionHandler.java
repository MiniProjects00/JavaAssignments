package com.maven.demo.exception;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import javax.persistence.NoResultException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

		/* ..........................................................
		
		 	@ControllerAdvice
		 	
		 		- Cause this class to invoke immediately 
		 		  (on program execution)
		 
		 
		 	@ExceptionHandler
		 	
		 		- handles exception caught
		 		
		 		- method name follows syntax:
		 		  handle'ExceptionName'TemplateData
		 
		 .......................................................... */


@ControllerAdvice		
public class AllExceptionHandler {

	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleIllegalArgumentExceptionTemplateData(IllegalArgumentException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.getCause().toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleNoSuchElementExceptionTemplateData(NoSuchElementException e)	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("No record found");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleNoResultExceptionTemplateData(NoResultException e)	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("No record found");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler
	public ResponseEntity<ExceptionTemplate> handleSalaryOutOfRangeExceptionTemplateData(SalaryOutOfRangeException e)	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleNullPointerExceptionTemplateData(NullPointerException e)	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
/*	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleInvalidIdExceptionTemplateData(IdNotFoundException e)	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler		
		public ResponseEntity<ExceptionTemplate> handleInvalidNameExceptionTemplateData(InvalidNameException e)	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
*/
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleInvalidInputFormatExceptionTemplateData(InvalidInputFormatException e)	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleNoRecordFoundExceptionTemplateData(NoRecordFoundException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleInvalidFilterRangeExceptionTemplateData(InvalidFilterRangeException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleDatabaseDataNotModifiedExceptionTemplateData(DBDataNotModifiedException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleProjectHasEmployeeExceptionTemplateData(ProjectHasEmployeeException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
}
