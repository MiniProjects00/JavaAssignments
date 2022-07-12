package com.maven.demo.dto;

public class BasicEmployeeDetailsResponseDTO {

	private int empId;
	private String name;
	private String email;
	private String designation;
	
	
	public BasicEmployeeDetailsResponseDTO() {
		super();
	}


	public BasicEmployeeDetailsResponseDTO(int empId, String name, String email, String designation) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.designation = designation;
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


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	@Override
	public String toString() {
		return "BasicEmployeeDetailsResponseDTO [empId=" + empId + ", name=" + name + ", email=" + email
				+ ", designation=" + designation + "]";
	}
	
}