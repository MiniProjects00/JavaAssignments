package com.maven.demo.exception;

public class SalaryOutOfRangeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorMsg;
	private String designation;
	private int userInput;
	
	
	public SalaryOutOfRangeException() {
		super();
	}

	public SalaryOutOfRangeException(String errorMsg, String designation, int userInput) {
		super();
		this.errorMsg = errorMsg;
		this.designation = designation;
		this.userInput = userInput;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getUserInput() {
		return userInput;
	}

	public void setUserInput(int userInput) {
		this.userInput = userInput;
	}

	@Override
	public String toString() {
		return "Salary of " + designation + " cannot be more than " +userInput;
	}

}
