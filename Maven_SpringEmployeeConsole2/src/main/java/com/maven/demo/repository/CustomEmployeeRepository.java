package com.maven.demo.repository;

import java.util.List;

import com.maven.demo.model.Employee;

public interface CustomEmployeeRepository {

	public Employee getEmployeeByName(String name);
	
	public List<Employee> getEmployeesWithinSalaryRange(int minSalary,int maxSalary);
	
	public boolean assignEmployeeToProject(int projectId,int empId);
	
	boolean unassignProject(int empId);
	
	public List<Employee> getListOfEmployeesInProject(int projectId);

}