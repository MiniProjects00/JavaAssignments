package com.maven.demo.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import javax.persistence.NoResultException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice		
public class AllExceptionHandler {

	
	//	getById, Id not found
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleNoSuchElementExceptionTemplateData(NoSuchElementException e)	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("Invalid id");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	//	getByName, name not found
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleNoResultExceptionTemplateData(NoResultException e)	{
		
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("No result found");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleDatabaseTableEmptyExceptionTemplateData(DatabaseTableEmptyException e)	{
		
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
	public ResponseEntity<ExceptionTemplate> handleLaptopStillLoanedOutExceptionnTemplateData(LaptopStillLoanedOutException e)	{
	
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
	
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleInvalidFilterRangeExceptionTemplateData(InvalidFilterRangeException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleLaptopNotAvailableExceptionTemplateData(LaptopNotAvailableException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleSQLIntegrityConstraintViolationExceptionTemplateData(SQLIntegrityConstraintViolationException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg("Integrity Constraint Violation, please check table mapping");
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleEmbeddedFieldCannotBeEmptyExceptionTemplateData(EmbeddedFieldCannotBeEmptyException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler		
	public ResponseEntity<ExceptionTemplate> handleLaptopNotAssignedToEmployeeExceptionTemplateData(LaptopNotAssignedToEmployeeException e)	{
	
		ExceptionTemplate template = new ExceptionTemplate();
		template.setMsg(e.getMessage());
		template.setUserInput(e.toString());
		template.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionTemplate>(template,HttpStatus.BAD_REQUEST);
	}
	
}