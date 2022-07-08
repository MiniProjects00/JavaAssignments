package com.maven.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.demo.model.Employee;
import com.maven.demo.model.Project;


@Service
@Transactional
public class CustomProjectRepositoryImpl implements CustomProjectRepository {

	@Autowired
	EntityManager springDataJPA;

	
	@Override
	public Project getProjectByName(String name) {
		
		String query = "from Project p where p.name = :name";
		Query q = springDataJPA.createQuery(query,Project.class);	
		q.setParameter("name", name);


		Project queryOutput = (Project) q.getSingleResult();
		
		return queryOutput;
		
	}
	
	public boolean updateProjectName(int projectId, String projectName) {

		String query = "update Project set name = :name where project_Id=:project_Id";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("project_Id", projectId);
		q.setParameter("name", projectName);
		
		int rowsAffected = q.executeUpdate();
		
		if(rowsAffected == 1)	{
			return true;
		}
		else	{
			return false;
		}
	}
	
	
	public boolean updateProjectListOfEmployees(int projectId, List<Employee> listOfEmployees) {

		String query = "update Project set listOfEmployees = :listOfEmployees where projectId=:projectId";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("projectId", projectId);
		q.setParameter("listOfEmployees", listOfEmployees);
		
		int rowsAffected = q.executeUpdate();
		
		if(rowsAffected == 1)	{
			return true;
		}
		else	{
			return false;
		}
	}

}
