package com.maven.demo.service;

import java.util.List;


import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.InvalidInputFormatException;
import com.maven.demo.exception.NoRecordFoundException;
import com.maven.demo.exception.ProjectHasEmployeeException;
import com.maven.demo.model.Project;


public interface ProjectService {

	
	public Project addProject(Project p) throws InvalidInputFormatException;
	
	public Project getProjectById(int projectId);
	
	public Project getProjectByName(String projectName);
	
	public List<Project> getAllProjects() throws NoRecordFoundException;
	
	public boolean deleteProject(int projectId) throws DBDataNotModifiedException, ProjectHasEmployeeException, NoRecordFoundException;

	public Project updateProjectName(int projectId, String projectName) throws DBDataNotModifiedException;

	
	
}
