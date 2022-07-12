package com.maven.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.demo.model.Employee;
import javax.transaction.Transactional;

@Service
@Transactional
public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository{
	
	
	//Create session object in hibernate 
	@Autowired
	EntityManager springDataJPA;

	
	//................................ getEmployeeByName ................................
	
	
	@Override
	public Employee getEmployeeByName(String name) {
		
		String query = "from Employee e where e.name = :name";
		Query q = springDataJPA.createQuery(query,Employee.class);	
		q.setParameter("name", name);

		Employee queryOutput = (Employee) q.getSingleResult();
		
		return queryOutput;
	}

	
	//.......................... getEmployeesWithinSalaryRange ..........................

	
	@Override
	public List<Employee> getEmployeesWithinSalaryRange(int minSalary, int maxSalary) {
		
		String query = "from Employee e where (e.salary >= :minSalary and e.salary <= :maxSalary)";
		
		Query q = springDataJPA.createQuery(query,Employee.class);
		q.setParameter("minSalary", minSalary);
		q.setParameter("maxSalary", maxSalary);
		
		List<Employee> resultList = q.getResultList();
		
		return resultList;
	}
	
	
	//............................. assignEmployeeToProject .............................

	
	@Override
	public boolean assignEmployeeToProject(int empId, int projectId) {
		
		String query = "update Employee set project_id=:projectId where emp_id=:empId";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("empId", empId);
		q.setParameter("projectId", projectId);
		
		int rowsAffected = q.executeUpdate();
		
		if(rowsAffected == 1)	{
			return true;
		}
		
		else	{
			return false;
		}
	}
	
	
	//............................. unassignProject .............................


	@Override
	public boolean unassignProject(int empId) {
		
		String query = "update Employee set project_id=null where emp_id=:empId";
		Query q = springDataJPA.createQuery(query);
		q.setParameter("empId", empId);
		
		int rowsAffected = q.executeUpdate();
		
		if(rowsAffected == 1)	{
			return true;
		}
		
		else	{
			return false;
		}
	}
	
	
	//............................ getListOfEmployeesInProject ............................

	
	public List<Employee> getListOfEmployeesInProject(int projectId)	{
		String query = "from Employee e where (project_id=:projectId)";
		
		Query q = springDataJPA.createQuery(query,Employee.class);
		q.setParameter("projectId", projectId);
		
		List<Employee> resultList = q.getResultList();
		
		return resultList;
	}
	
}