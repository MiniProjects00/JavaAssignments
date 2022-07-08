package com.maven.demo.service;

import java.util.List;

import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.InvalidFilterRangeException;
import com.maven.demo.exception.InvalidInputFormatException;
import com.maven.demo.exception.NoRecordFoundException;
import com.maven.demo.exception.SalaryOutOfRangeException;
import com.maven.demo.model.Employee;
import com.maven.demo.dto.AddEmployeeDTO;

public interface EmployeeService {


	public Employee addEmployee(AddEmployeeDTO e) throws SalaryOutOfRangeException, InvalidInputFormatException, NoRecordFoundException;

	public Employee getEmployeeById(int empId) throws NoRecordFoundException;
	
	public Employee getEmployeeByName(String empName) throws NoRecordFoundException;
	
	public List<Employee> getAllEmployees() throws NoRecordFoundException;
	
	public List<Employee> getEmployeesWithinSalaryRange(int minSalary, int maxSalary) throws NoRecordFoundException, InvalidFilterRangeException;
	
	public Employee assignProjectToEmployee(int projectId, int empId) throws DBDataNotModifiedException, NoRecordFoundException;

	public List<Employee> getListOfEmployeesInProject(int projectId);
	
	public boolean deleteEmployee(int empId) throws DBDataNotModifiedException, NoRecordFoundException;
	
	
}
