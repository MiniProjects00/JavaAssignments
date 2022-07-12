package com.maven.demo.dto;

import java.time.LocalDate;
import java.util.List;

import com.maven.demo.model.Address;
import com.maven.demo.model.Dependent;
import com.maven.demo.model.Laptop;

public class HR_EmployeesResponseDTO {

	
	private int empId;
	private String name;
	private LocalDate dateOfBirth;
	private String mobileNumber;
	private String email;
	private Address address;		
	private String bankAcc;
	private String designation;
	private int salary;
	private List<Dependent> dependentList;
	private Laptop laptop;
	
	
	public HR_EmployeesResponseDTO() {
		super();
	}


	public HR_EmployeesResponseDTO(int empId, String name, LocalDate dateOfBirth, String mobileNumber, String email,
			Address address, String bankAcc, String designation, int salary, List<Dependent> dependentList, Laptop laptop) {
		super();
		this.empId = empId;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.bankAcc = bankAcc;
		this.designation = designation;
		this.salary = salary;
		this.dependentList = dependentList;
		this.laptop = laptop;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getBankAcc() {
		return bankAcc;
	}


	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Laptop getLaptop() {
		return laptop;
	}


	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}


	public List<Dependent> getDependentList() {
		return dependentList;
	}

	
	public void setDependentList(List<Dependent> dependentList) {
		this.dependentList = dependentList;
	}


	@Override
	public String toString() {
		return "HR_EmployeesResponseDTO [empId=" + empId + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", address=" + address + ", bankAcc="
				+ bankAcc + ", designation=" + designation + ", salary=" + salary + ", dependentList=" + dependentList
				+ ", laptop=" + laptop + "]";
	}
	
}