package com.maven.demo.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


																	
@Entity																
public class Employee implements Comparable<Employee>, Serializable {

	private static final long serialVersionUID = 1L;									
																
	@Id		
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String address;												
	
	@Column(nullable=false)
	private int bankAcc;
	
	@Column(nullable=false)
	private String designation;
	
	@Column(nullable=false)
	private int salary;
																																	
	@JoinColumn(name="project_id")	
	@JsonBackReference												
	private Project projectAssigned;
	
																	
	public Employee()	{}

	
	//Without "Project project"
	public Employee(int empId, String name, String email, String address, int bankAcc, String designation, int salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.bankAcc = bankAcc;
		this.designation = designation;
		this.salary = salary;
	}
	
	
	//Without empId: empId auto generated, not required for object creation
	public Employee(String name, String email, String address, int bankAcc, String designation, int salary,
		Project projectAssigned) {
	super();
	this.name = name;
	this.email = email;
	this.address = address;
	this.bankAcc = bankAcc;
	this.designation = designation;
	this.salary = salary;
	this.projectAssigned = projectAssigned;
}
	
	//Full constructor
	public Employee(int empId, String name, String email, String address, int bankAcc, String designation, int salary,
			Project projectAssigned) {
		super();
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.bankAcc = bankAcc;
		this.designation = designation;
		this.salary = salary;
		this.projectAssigned = projectAssigned;
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
	
	
	public Project getProjectAssigned() {
		return projectAssigned;
	}

	
	public void setProjectAssigned(Project projectAssigned) {
		this.projectAssigned = projectAssigned;
	}

	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", bankAcc=" + bankAcc + ", designation=" + designation + ", salary=" + salary + ", projectAssigned="
				+ projectAssigned + "]";
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + bankAcc;
		result = prime * result + ((designation == null) ? 0 : designation.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + empId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + salary;
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (bankAcc != other.bankAcc)
			return false;
		if (designation == null) {
			if (other.designation != null)
				return false;
		} else if (!designation.equals(other.designation))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (empId != other.empId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectAssigned != other.projectAssigned)
			return false;
		if (salary != other.salary)
			return false;
		return true;
	}

	
	@Override
	public int compareTo(Employee e) {
		
		return this.getEmpId() - e.getEmpId();
	}

}