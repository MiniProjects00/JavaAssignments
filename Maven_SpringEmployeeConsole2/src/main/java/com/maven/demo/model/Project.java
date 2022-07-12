package com.maven.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Project implements Comparable<Project>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id									
	private int projectId;
	
	@NotEmpty(message = "Project name required")
	private String name;
	
	private int cost;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endDate;
	
	private String comments;
	
	@OneToOne
	@JoinColumn(name = "emp_id")
	Employee projectLeader;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference													
	@JoinColumn(name="project_id")								
	List<Employee> listOfEmployees; 										

	
	public Project() {}	
	
	
	//	Minimum required for project creation
	public Project(int projectId, String name) {
		super();
		this.projectId = projectId;
		this.name = name;
	}
	

	//	Full constructor
	public Project(int projectId, String name, int cost, LocalDate startDate, LocalDate endDate, String comments,
			Employee projectLeader, List<Employee> listOfEmployees) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.cost = cost;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comments = comments;
		this.projectLeader = projectLeader;
		this.listOfEmployees = listOfEmployees;
	}

	
	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Employee getProjectLeader() {
		return projectLeader;
	}


	public void setProjectLeader(Employee projectLeader) {
		this.projectLeader = projectLeader;
	}
	
	
	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}


	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", cost=" + cost + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", comments=" + comments + ", projectLeader=" + projectLeader
				+ ", listOfEmployees=" + listOfEmployees + "]";
	}

	
	public int compareTo(Project p) {
		
		return this.getProjectId() - p.getProjectId();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + cost;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((listOfEmployees == null) ? 0 : listOfEmployees.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + projectId;
		result = prime * result + ((projectLeader == null) ? 0 : projectLeader.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
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
		Project other = (Project) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (cost != other.cost)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (listOfEmployees == null) {
			if (other.listOfEmployees != null)
				return false;
		} else if (!listOfEmployees.equals(other.listOfEmployees))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectId != other.projectId)
			return false;
		if (projectLeader == null) {
			if (other.projectLeader != null)
				return false;
		} else if (!projectLeader.equals(other.projectLeader))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
}