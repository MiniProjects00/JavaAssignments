package com.maven.demo.service;

import java.util.List;


import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.DatabaseTableEmptyException;
import com.maven.demo.exception.ProjectHasEmployeeException;
import com.maven.demo.model.Project;

public interface ProjectService {
	
	public Project addProject(Project p);
	
	public List<Project> getAllProjects() throws DatabaseTableEmptyException;
	
	public Project getProjectById(int projectId);
	
	public Project getProjectByName(String projectName);

	public Project updateProjectName(int projectId, String projectName) throws DBDataNotModifiedException;
	
	public Project updateProjectDetails(int projectId, Project projectDetailsToUpdate);

	public Project assignProjectLeader(int projectId, int empId);

	public Project unassignProjectLeader(int projectId);

	public boolean deleteProject(int projectId) throws DBDataNotModifiedException, ProjectHasEmployeeException;
	
}