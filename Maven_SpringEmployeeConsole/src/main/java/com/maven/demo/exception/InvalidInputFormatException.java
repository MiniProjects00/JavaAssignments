package com.maven.demo.exception;

public class InvalidInputFormatException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMsg;
	private String nameOfField;
	private String userInputValue;
	
	
	public InvalidInputFormatException() {
		super();
	}

	public InvalidInputFormatException(String errorMsg, String nameOfField, String userInputValue) {
		super();
		this.errorMsg = errorMsg;
		this.nameOfField = nameOfField;
		this.userInputValue = userInputValue;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getNameOfField() {
		return nameOfField;
	}

	public void setNameOfField(String nameOfField) {
		this.nameOfField = nameOfField;
	}

	public String getUserInputValue() {
		return userInputValue;
	}

	public void setUserInputValue(String userInputValue) {
		this.userInputValue = userInputValue;
	}

	@Override
	public String toString() {
		return ("Missing or invalid format" + nameOfField );
	}

}
