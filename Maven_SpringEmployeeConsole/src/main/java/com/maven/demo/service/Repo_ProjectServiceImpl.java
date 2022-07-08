package com.maven.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.InvalidInputFormatException;
import com.maven.demo.exception.NoRecordFoundException;
import com.maven.demo.exception.ProjectHasEmployeeException;
import com.maven.demo.model.Employee;
import com.maven.demo.model.Project;
import com.maven.demo.repository.EmployeeRepository;
import com.maven.demo.repository.ProjectRepository;
import com.maven.demo.util.ValidateProject;


@Service
public class Repo_ProjectServiceImpl implements ProjectService{
	
		
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ValidateProject validateProject;
	
	//......................... addProject .........................

	@Override
	public Project addProject(Project project) throws InvalidInputFormatException {
		
		if(project != null)	{
			
			//~~~~~~~~~~ Check for missing inputs ~~~~~~~~~~
			
			List<String> listOfMissingFields = validateProject.validateProjectInputFields(project);

			if(listOfMissingFields.size() > 0)	{
				String missingFields = "";
				
				for(String s : listOfMissingFields)	{
					missingFields = missingFields + " [" + s + "] ";
				}
				System.err.println(missingFields);
				throw new InvalidInputFormatException("", missingFields, "");
			}
			
		
			Project savedEntity =  projectRepository.save(project);
			return savedEntity;
		}
		
		else {
			throw new NullPointerException("No project information entered!");
		}
	}
	//......................... getProjectById .........................

	@Override
	public Project getProjectById(int projectId) {
		Project projectReturned =  projectRepository.findById(projectId).get();

		if(projectReturned != null)	{
			
			List<Employee> listOfEmployees = projectReturned.getListOfEmployees();
			System.out.println("listOfEmployees.size()  " + listOfEmployees.size());

			for(Employee e : listOfEmployees) {
				System.out.println("*****" + e);
			}
			return projectReturned;
		}
		else	{
			return null;
		}

		
	}
	//......................... getProjectByName .........................

	@Override
	public Project getProjectByName(String projectName) {
		Project projectReturned =  projectRepository.getProjectByName(projectName);
		
		if(projectReturned != null)	{
			return projectReturned;
		}
		
		else {
			return null;
			
			//Internally throws NoResultException
			//throw new NoRecordFoundException("", "Project", "name", projectName);
		}
	}
	
	//......................... getAllProjects .........................

	@Override
	public List<Project> getAllProjects() throws NoRecordFoundException {
			List<Project> listOfProjects = projectRepository.findAll();
		
		if (listOfProjects.size() > 0)	{
			return projectRepository.findAll();
		}
		else {
			throw new NoRecordFoundException("", "projects", "Project table", "empty");
		}
	}
	//......................... updateProjectName .........................

	@Override
	public Project updateProjectName(int projectId, String projectName) throws DBDataNotModifiedException {
		
		if(projectRepository.existsById(projectId))	{
			
			boolean updated = projectRepository.updateProjectName(projectId, projectName);	
		
			if(updated)	{
				return getProjectById(projectId);
			}
			else	{
				throw new DBDataNotModifiedException("", "update", "projectName");
			}
		}
		else	{
			return null;
		}
		
	}
	
	
	//......................... deleteProject .........................

	@Override
	public boolean deleteProject(int projectId) throws DBDataNotModifiedException, ProjectHasEmployeeException, NoRecordFoundException {
		if(projectRepository.existsById(projectId))	{
			
			//Find if any Emp is assigned to project
			List<Employee> listOfEmployeesInProject = employeeRepository.getListOfEmployeesInProject(projectId);
			if(listOfEmployeesInProject.size() == 0)	{
				
				projectRepository.deleteById(projectId);

				//Check if record deleted
				if(projectRepository.existsById(projectId))	{			
					throw new DBDataNotModifiedException("", "delete", "employee");
				}
				
				else {
					return true;
				}
			}
			else	{
				throw new ProjectHasEmployeeException("", projectId);
				
			}
		}
		else	{
			//Required
			throw new NoRecordFoundException("", "project", "id", (String.valueOf(projectId)));
		}
	}
	
}

