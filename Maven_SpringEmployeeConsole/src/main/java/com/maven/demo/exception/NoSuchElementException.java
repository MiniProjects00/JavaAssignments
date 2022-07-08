package com.maven.demo.exception;

public class NoSuchElementException {
	

	private String errorMsg;
	private String objectType;	//project or employee
	private String queryType;
	private String userInputValue;

	public NoSuchElementException()	{}

	public NoSuchElementException(String errorMsg, String objectType, String queryType, String userInputValue) {
		super();
		this.errorMsg = errorMsg;
		this.objectType = objectType;
		this.queryType = queryType;
		this.userInputValue = userInputValue;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getUserInputValue() {
		return userInputValue;
	}

	public void setUserInputValue(String userInputValue) {
		this.userInputValue = userInputValue;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	@Override
	public String toString() {
		return ("No record found");

	}
	
}
