package com.maven.demo.exception;

public class DatabaseTableEmptyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	private String tableName;
	
	
	public DatabaseTableEmptyException()	{}

	
	public DatabaseTableEmptyException(String errorMsg, String tableName) {
		super();
		this.errorMsg = errorMsg;
		this.tableName = tableName;
	}

	
	public String getErrorMsg() {
		return errorMsg;
	}

	
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	
	public String getTableName() {
		return tableName;
	}

	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	
	@Override
	public String toString() {
		return (tableName + " table is empty!");
	}
	
}