package com.maven.demo.exception;

public class ProjectHasEmployeeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	private int id;

	
	public ProjectHasEmployeeException()	{}

	
	public ProjectHasEmployeeException(String errorMsg, int id) {
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
		return ("Unable to delete project " + id + " as 1 or more employees are still assigned to it");
	}
	
}