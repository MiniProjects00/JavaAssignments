package com.maven.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Project implements Comparable<Project>, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id																	
	private int projectId;
	private String name;
	private int cost;
	private String startDate;
	private String endDate;
	private String comments;
	private String headEmail;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference													
	@JoinColumn(name="project_id")
	List<Employee> listOfEmployees; 									
	
	//........................................ constructor ........................................

	
	public Project() {}	
	
	
	public Project(int projectId, String name) {
		super();
		this.projectId = projectId;
		this.name = name;
	}
	
	
	public Project(int projectId, String name, String headEmail) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.headEmail = headEmail;
	}

	
	public Project(int projectId, String name, int cost, String startDate, String endDate, String comments,
			String headEmail, List<Employee> listOfEmployees) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.cost = cost;
		this.startDate = startDate;
		this.endDate = endDate;
		this.comments = comments;
		this.headEmail = headEmail;
		this.listOfEmployees = listOfEmployees;
	}

	
	//........................................ getter / setter ........................................

	
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


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getHeadEmail() {
		return headEmail;
	}


	public void setHeadEmail(String headEmail) {
		this.headEmail = headEmail;
	}
	
	
	//........................................ toString() ........................................


	public List<Employee> getListOfEmployees() {
		return listOfEmployees;
	}


	public void setListOfEmployees(List<Employee> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}


/*	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", cost=" + cost + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", comments=" + comments + ", headEmail=" + headEmail + ", listOfEmployees="
				+ listOfEmployees + "]";
	}
*/
	
	//........................................ hashCode() ........................................

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + cost;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((headEmail == null) ? 0 : headEmail.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + projectId;
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}
	
	
	//........................................ equals() ........................................


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
		if (headEmail == null) {
			if (other.headEmail != null)
				return false;
		} else if (!headEmail.equals(other.headEmail))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectId != other.projectId)
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	
	//........................................ compareTo() ........................................

	
	public int compareTo(Project p) {
		
		return this.getProjectId() - p.getProjectId();
	}
	
}
