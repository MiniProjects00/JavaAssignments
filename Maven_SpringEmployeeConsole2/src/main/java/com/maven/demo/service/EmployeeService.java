package com.maven.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.DatabaseTableEmptyException;
import com.maven.demo.exception.EmbeddedFieldCannotBeEmptyException;
import com.maven.demo.exception.InvalidFilterRangeException;
import com.maven.demo.exception.LaptopNotAssignedToEmployeeException;
import com.maven.demo.exception.LaptopNotAvailableException;
import com.maven.demo.model.Address;
import com.maven.demo.model.Dependent;
import com.maven.demo.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(@Valid Employee employee) throws EmbeddedFieldCannotBeEmptyException;
	
	public List<Employee> getAllEmployees() throws DatabaseTableEmptyException;

	public Employee getEmployeeById(int empId);
	
	public Employee getEmployeeByName(String empName);
	
	public List<Employee> getEmployeesWithinSalaryRange(int minSalary, int maxSalary) throws InvalidFilterRangeException;
	
	public List<Employee> getListOfEmployeesInProject(int projectId);
	
	public Employee updateAddress(int empId, Address address) throws EmbeddedFieldCannotBeEmptyException;

	public Employee assignProjectToEmployee(int projectId, int empId) throws DBDataNotModifiedException;
	
	public Employee unassignProject(int empId, int projectId) throws DBDataNotModifiedException;

	public Employee addDependentList(int empId, List<Dependent> dependentList) throws EmbeddedFieldCannotBeEmptyException;
	
	public Employee removeDependentList(int empId);

	public Employee addLaptopDetails(int empId, int laptopSerialNumber) throws LaptopNotAvailableException;

	public Employee removeLaptopDetails(int empId, int laptopId) throws DBDataNotModifiedException, LaptopNotAssignedToEmployeeException;
	
	public boolean deleteEmployee(int empId) throws DBDataNotModifiedException;
	
}