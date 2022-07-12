package com.maven.demo.exception;

import java.time.LocalDateTime;

public class ExceptionTemplate {

	private String userInput;
	private String msg;
	private LocalDateTime dateTime;
	
	
	public ExceptionTemplate() {
		super();
	}


	public ExceptionTemplate(String userInput, String msg, LocalDateTime dateTime) {
		super();
		this.userInput = userInput;
		this.msg = msg;
		this.dateTime = dateTime;
	}


	public String getUserInput() {
		return userInput;
	}


	public void setUserInput(String userInput) {
		this.userInput = userInput;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public LocalDateTime getDateTime() {
		return dateTime;
	}


	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}


	@Override
	public String toString() {
		return "ExceptionTemplate [userInput=" + userInput + ", msg=" + msg + ", dateTime=" + dateTime + "]";
	}
	
}