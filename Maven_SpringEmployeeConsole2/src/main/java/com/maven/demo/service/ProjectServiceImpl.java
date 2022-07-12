package com.maven.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.DatabaseTableEmptyException;
import com.maven.demo.exception.ProjectHasEmployeeException;
import com.maven.demo.model.Employee;
import com.maven.demo.model.Project;
import com.maven.demo.repository.EmployeeRepository;
import com.maven.demo.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
		
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	//............................ addProject ............................

	
	@Override
	public Project addProject(Project project)  {
		
		String projectName = project.getName();
		
		if(projectName.contains(" "))	{
			projectName = projectName.replace(" ", "_");
			project.setName(projectName);
		}
		
		Project savedEntity =  projectRepository.save(project);
		
		return savedEntity;
	}
	
	
	//.......................... getAllProjects ..........................

	
	@Override
	public List<Project> getAllProjects() throws DatabaseTableEmptyException {
			
		List<Project> listOfProjects = projectRepository.findAll();
		
		if (listOfProjects.size() > 0)	{
			return projectRepository.findAll();
		}
		
		else {
			throw new DatabaseTableEmptyException("", "Project");
		}
	}
	
	
	//.......................... getProjectById ..........................

	
	@Override
	public Project getProjectById(int projectId) {

		if(projectRepository.existsById(projectId))	{
			
			Project projectReturned =  projectRepository.findById(projectId).get();
			
			return projectReturned;
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}


	//........................ getProjectByName .........................

	
	@Override
	public Project getProjectByName(String projectName) {
		
		Project projectReturned =  projectRepository.getProjectByName(projectName);
		
		if(projectReturned != null)	{
			return projectReturned;
		}
		
		else	{
			throw new NoResultException();
		}
	}	
	
	
	//........................ updateProjectName ........................

	
	@Override
	public Project updateProjectName(int projectId, String projectName) throws DBDataNotModifiedException {
		
		if(projectRepository.existsById(projectId))	{
			
			if(projectName.contains(" "))	{
				projectName = projectName.replace(" ", "_");
			}
			
			boolean updated = projectRepository.updateProjectName(projectId, projectName);	
		
			if(updated)	{
				return getProjectById(projectId);
			}
			
			else	{
				throw new DBDataNotModifiedException("", "Project");
			}
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}
	
	
	//....................... updateProjectDetails ......................

	
	@Override
	public Project updateProjectDetails(int projectId, Project projectDetailsToUpdate) {
		
		if(projectRepository.existsById(projectId))	{
			
			Project projectRetrieved = projectRepository.findById(projectId).get();

			if(projectDetailsToUpdate.getStartDate() != null)	{
				LocalDate startDate = projectDetailsToUpdate.getStartDate();
				projectRetrieved.setStartDate(startDate);
			}
			
			if(projectDetailsToUpdate.getEndDate() != null)	{
				LocalDate endDate = projectDetailsToUpdate.getEndDate();
				projectRetrieved.setEndDate(endDate);
			}
			
			if(projectDetailsToUpdate.getCost() != 0)	{
				int cost = projectDetailsToUpdate.getCost();
				projectRetrieved.setCost(cost);
			}
			
			if(projectDetailsToUpdate.getComments() != null)	{
				String comments = projectDetailsToUpdate.getComments();
				projectRetrieved.setComments(comments);
			}
	
			Project projectSaved = projectRepository.save(projectRetrieved);
	
			return projectSaved;
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}
	
	
	//....................... assignProjectLeader .......................

	
	@Override
	public Project assignProjectLeader(int projectId, int empId) {
		
		if(projectRepository.existsById(projectId))	{
			
			if(employeeRepository.existsById(empId))	{

				Employee employeeRetrieved = employeeRepository.findById(empId).get();
				
				Project projectRetrieved = projectRepository.findById(projectId).get();
				
				projectRetrieved.setProjectLeader(employeeRetrieved);
				
				Project projectSaved = projectRepository.save(projectRetrieved);
				
				return projectSaved;
			}
			
			else	{
				throw new NoSuchElementException();
			}
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}
	
	
	//...................... unassignProjectLeader ......................

	
	@Override
	public Project unassignProjectLeader(int projectId) {
		
		if(projectRepository.existsById(projectId))	{
			
			Project projectRetrieved = projectRepository.findById(projectId).get();
		
			projectRetrieved.setProjectLeader(null);
			
			Project projectSaved = projectRepository.save(projectRetrieved);
			
			return projectSaved;
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}
	
	
	//.......................... deleteProject ..........................

	
	@Override
	public boolean deleteProject(int projectId) throws DBDataNotModifiedException, ProjectHasEmployeeException {
		
		if(projectRepository.existsById(projectId))	{
			
			List<Employee> listOfEmployeesInProject = employeeRepository.getListOfEmployeesInProject(projectId);
			
			if(listOfEmployeesInProject.size() == 0)	{
				
				projectRepository.deleteById(projectId);

				//Check if record deleted
				if(projectRepository.existsById(projectId))	{			
					throw new DBDataNotModifiedException("", "Project");
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
			throw new NoSuchElementException();
		}
	}
	
}