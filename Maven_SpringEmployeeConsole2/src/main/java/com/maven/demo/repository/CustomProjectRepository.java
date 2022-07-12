package com.maven.demo.repository;

import java.util.List;

import com.maven.demo.model.Employee;
import com.maven.demo.model.Project;

public interface CustomProjectRepository {
	
	public Project getProjectByName(String name);
	
	public boolean updateProjectName(int projectId, String projectName);
	
	public boolean updateProjectListOfEmployees(int projectId, List<Employee> listOfEmployees);

}
