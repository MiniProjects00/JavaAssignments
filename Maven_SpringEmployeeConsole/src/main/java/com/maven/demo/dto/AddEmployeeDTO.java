package com.maven.demo.dto;

public class AddEmployeeDTO {
	
	
	private int empId;
	private String name;
	private String email;
	private String address;
	private int bankAcc;
	private String designation;
	private int salary;
	private int projectId;
	
	
	public AddEmployeeDTO() {
		super();
	}


	public AddEmployeeDTO(int empId, String name, String email, String address, int bankAcc, String designation,
			int salary, int projectId) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.bankAcc = bankAcc;
		this.designation = designation;
		this.salary = salary;
		this.projectId = projectId;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getBankAcc() {
		return bankAcc;
	}


	public void setBankAcc(int bankAcc) {
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


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	@Override
	public String toString() {
		return "AddEmployeeDTO [empId=" + empId + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", bankAcc=" + bankAcc + ", designation=" + designation + ", salary=" + salary + ", projectId="
				+ projectId + "]";
	}
	
}
