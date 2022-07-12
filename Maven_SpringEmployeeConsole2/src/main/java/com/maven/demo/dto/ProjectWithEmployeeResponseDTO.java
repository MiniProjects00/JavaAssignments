package com.maven.demo.dto;

import java.time.LocalDate;
import java.util.List;

public class ProjectWithEmployeeResponseDTO {


	private int projectId;
	private String name;
	private int cost;
	private LocalDate startDate;
	private LocalDate endDate;
	private String comments;
	BasicEmployeeDetailsResponseDTO projectLeader;
	List<BasicEmployeeDetailsResponseDTO> listOfEmployees;
	
	
	public ProjectWithEmployeeResponseDTO() {
		super();
	}


	public ProjectWithEmployeeResponseDTO(int projectId, String name, int cost, LocalDate startDate, LocalDate endDate,
			String comments, BasicEmployeeDetailsResponseDTO projectLeader,
			List<BasicEmployeeDetailsResponseDTO> listOfEmployees) {
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


	public BasicEmployeeDetailsResponseDTO getProjectLeader() {
		return projectLeader;
	}


	public void setProjectLeader(BasicEmployeeDetailsResponseDTO projectLeader) {
		this.projectLeader = projectLeader;
	}


	public List<BasicEmployeeDetailsResponseDTO> getListOfEmployees() {
		return listOfEmployees;
	}


	public void setListOfEmployees(List<BasicEmployeeDetailsResponseDTO> listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}


	@Override
	public String toString() {
		return "ProjectWithEmployeeResponseDTO [projectId=" + projectId + ", name=" + name + ", cost=" + cost
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", comments=" + comments + ", projectLeader="
				+ projectLeader + ", listOfEmployees=" + listOfEmployees + "]";
	} 	
	
}