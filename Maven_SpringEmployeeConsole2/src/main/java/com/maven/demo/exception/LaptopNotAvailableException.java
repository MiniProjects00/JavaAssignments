package com.maven.demo.exception;

public class LaptopNotAvailableException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	private int id;

	
	public LaptopNotAvailableException()	{}

	
	public LaptopNotAvailableException(String errorMsg, int id) {
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
		return ("Laptop " + id + " unavailable!");
	}
	
}