package com.maven.demo.exception;

public class DBDataNotModifiedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	private String dbOperationType;
	private String objectType;		//projectName, empSalary, etc

	public DBDataNotModifiedException()	{}

	public DBDataNotModifiedException(String errorMsg, String dbOperationType, String objectType) {
		super();
		this.errorMsg = errorMsg;
		this.dbOperationType = dbOperationType;
		this.objectType = objectType;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getDbOperationType() {
		return dbOperationType;
	}

	public void setDbOperationType(String dbOperationType) {
		this.dbOperationType = dbOperationType;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	@Override
	public String toString() {
		return ("An error has occurred, unable to " + dbOperationType + " [" + objectType + "]");
	}

}
