package com.maven.demo.exception;

public class EmbeddedFieldCannotBeEmptyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	
	
	public EmbeddedFieldCannotBeEmptyException()	{}

	
	public EmbeddedFieldCannotBeEmptyException(String errorMsg) {
		super();
		this.errorMsg = errorMsg;
	}

	
	public String getErrorMsg() {
		return errorMsg;
	}

	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
	@Override
	public String toString() {
		return ("One or more requried fields missing");
	}
	
}