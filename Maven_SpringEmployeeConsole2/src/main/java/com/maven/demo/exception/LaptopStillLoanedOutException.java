package com.maven.demo.exception;

public class LaptopStillLoanedOutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	private int id;

	
	public LaptopStillLoanedOutException()	{}

	
	public LaptopStillLoanedOutException(String errorMsg, int id) {
		super();
		this.errorMsg = errorMsg;
		this.id = id;
		this.id = id;
	}

	
	public String getErrorMsg() {
		return errorMsg;
	}

	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	

	public int getid() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		return ("Unable to delete laptop " + id + " as it has not been returned");
	}
	
}