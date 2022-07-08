package com.maven.demo.exception;

//Not used

public class IdNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	private String idType;
	private int userInputValue;

	public IdNotFoundException()	{}

	public IdNotFoundException(String errorMsg, String idType, int userInputValue) {
		super();
		this.errorMsg = errorMsg;
		this.idType = idType;
		this.userInputValue = userInputValue;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public int getUserInputValue() {
		return userInputValue;
	}

	public void setUserInputValue(int userInputValue) {
		this.userInputValue = userInputValue;
	}

	@Override
	public String toString() {
		return (idType + " " + userInputValue + " not found!");
	}

}
