package com.maven.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity					// <- have a table of its own in DB
public class Laptop {
	
	@Id
	private String serialNumber;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="employee_id")
	private Employee employeeLoanedTo;
	
	private String dateOfLoan;
	
	private String availability;

	public Laptop() {
		super();
	}

	public Laptop(String serialNumber, Employee employeeLoanedTo, String dateOfLoan, String availability) {
		super();
		this.serialNumber = serialNumber;
		this.employeeLoanedTo = employeeLoanedTo;
		this.dateOfLoan = dateOfLoan;
		this.availability = availability;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public Employee getEmployeeLoanedTo() {
		return employeeLoanedTo;
	}

	public void setEmployeeLoanedTo(Employee employeeLoanedTo) {
		this.employeeLoanedTo = employeeLoanedTo;
	}

	public String getDateOfLoan() {
		return dateOfLoan;
	}

	public void setDateOfLoan(String dateOfLoan) {
		this.dateOfLoan = dateOfLoan;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Laptop [serialNumber=" + serialNumber + ", employeeLoanedTo=" + employeeLoanedTo + ", dateOfLoan="
				+ dateOfLoan + ", availability=" + availability + "]";
	}
	
}
