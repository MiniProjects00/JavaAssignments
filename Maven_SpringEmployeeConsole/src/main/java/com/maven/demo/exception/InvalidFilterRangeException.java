package com.maven.demo.exception;

public class InvalidFilterRangeException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	private String queryType;
	private int userMinValue;
	private int userMaxValue;


	public InvalidFilterRangeException()	{}

	public InvalidFilterRangeException(String errorMsg, String queryType, int userMinValue, int userMaxValue) {
		super();
		this.errorMsg = errorMsg;
		this.queryType = queryType;
		this.userMinValue = userMinValue;
		this.userMaxValue = userMaxValue;
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

	public int getUserMinValue() {
		return userMinValue;
	}

	public void setUserMinValue(int userMinValue) {
		this.userMinValue = userMinValue;
	}

	public int getUserMaxValue() {
		return userMaxValue;
	}

	public void setUserMaxValue(int userMaxValue) {
		this.userMaxValue = userMaxValue;
	}

	@Override
	public String toString() {
		return ("Invalid filter criteria for " +  queryType + "\n" +
				"You have entered: \n" +
				"Min value = " + userMinValue + "\n" + 
				"Max value = " + userMaxValue);
	}
}
