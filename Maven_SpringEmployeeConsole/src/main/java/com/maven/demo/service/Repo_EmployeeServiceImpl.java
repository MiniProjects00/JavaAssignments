package com.maven.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.demo.dto.AddEmployeeDTO;
import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.InvalidFilterRangeException;
import com.maven.demo.exception.InvalidInputFormatException;
import com.maven.demo.exception.NoRecordFoundException;
import com.maven.demo.exception.SalaryOutOfRangeException;
import com.maven.demo.model.Employee;
import com.maven.demo.model.Project;
import com.maven.demo.repository.EmployeeRepository;
import com.maven.demo.repository.ProjectRepository;
import com.maven.demo.util.ValidateProject;
import com.maven.demo.util.ValidateEmployee;


@Service
public class Repo_EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	ValidateEmployee validateEmployee;
	
	@Autowired
	ValidateProject validateProject;
	
	//........................... addEmployee ...........................

	public Employee addEmployee(AddEmployeeDTO empDTO) throws SalaryOutOfRangeException, InvalidInputFormatException {
		
		if(empDTO!=null)	{
			Employee emp = new Employee();
			Project projectDetails = new Project();
			
			//~~~~~~~~~~ Check for missing inputs ~~~~~~~~~~
			
			List<String> listOfMissingFields = validateEmployee.validateEmployeeInputFields(empDTO);

			if(listOfMissingFields.size() > 0)	{
				String missingFields = "";
				
				for(String s : listOfMissingFields)	{
					missingFields = missingFields + " [" + s + "] ";
				}
				System.err.println(missingFields);
				throw new InvalidInputFormatException("", missingFields, "");
			}
		
			//~~~~~~~~~~ Retrieve project details ~~~~~~~~~~
			
			int projectId = empDTO.getProjectId();
			
			if(projectId == 0)	{}											
			else if(projectRepository.existsById(projectId))	{			 
				projectDetails = projectRepository.findById(projectId).get();
			}
			else	{													
				return null;
			}
			
			//~~~~~~~~~~ Create Employee Object ~~~~~~~~~~
			
			emp.setName(empDTO.getName());
			emp.setEmail(empDTO.getEmail());
			emp.setAddress(empDTO.getAddress());
			emp.setBankAcc(empDTO.getBankAcc());
			emp.setDesignation(empDTO.getDesignation());
			emp.setSalary(empDTO.getSalary());
			emp.setProjectAssigned(projectDetails);	
			
			//~~~~~~~~~~ Save Employee Object into DB ~~~~~~~~~~
			
			Employee savedEntity =  employeeRepository.save(emp);
			return savedEntity;
		}
		
		else {
			throw new NullPointerException("No employee information entered!");
		}
	}

	//......................... getAllEmployees .........................
	
	@Override
	public List<Employee> getAllEmployees() throws NoRecordFoundException {
		
		List<Employee> listOfEmployees = employeeRepository.findAll();
		
		if (listOfEmployees.size() > 0)	{
			return employeeRepository.findAll();
		}
		else {
			throw new NoRecordFoundException("", "employee", "Employee table", "empty");
		}
	}

	//......................... getEmployeeById ..........................
	
	@Override
	public Employee getEmployeeById(int empId) {
		
		Employee employeeReturned =  employeeRepository.findById(empId).get();
		
		if(employeeReturned != null)	{
			return employeeReturned;
		}
		
		else {
			return null;
			
			//Internally throws NoSuchElementException
			//throw new NoRecordFoundException("", "employee", "id", String.valueOf(empId));
		}
	}

	//.......................... getEmployeeByName ..........................

	@Override
	public Employee getEmployeeByName(String empName) throws NoRecordFoundException {
		
		Employee employeeReturned =  employeeRepository.getEmployeeByName(empName);
		
		if(employeeReturned != null)	{
			return employeeReturned;
		}
		
		else {
			return null;
		}
	}
	//.......................... getEmployeesWithinSalaryRange ..........................

	@Override
	public List<Employee> getEmployeesWithinSalaryRange(int minSalary, int maxSalary) throws NoRecordFoundException, InvalidFilterRangeException {
		
		boolean rangeValid = validateEmployee.validateFilterRange(minSalary, maxSalary);
		
		if(rangeValid)	{
			List<Employee> listOfEmployees = employeeRepository.getEmployeesWithinSalaryRange(minSalary, maxSalary);
			if(listOfEmployees.size() > 0)	{
				return listOfEmployees;
			}
			else	{
				throw new NoRecordFoundException("", "employee", "salary", ("min:  " + minSalary + ", max: " + maxSalary));
			}
		}
		else {
			throw new InvalidFilterRangeException("", "salary", minSalary, maxSalary);
		}
	}


	//.......................... assignProjectToEmployee ..........................

	
	@Override
	public Employee assignProjectToEmployee(int empId, int projectId) throws DBDataNotModifiedException {
		
		if(employeeRepository.existsById(empId) && projectRepository.existsById(projectId))	{
			
			
			//Update Employee table
			boolean updated = employeeRepository.assignEmployeeToProject(empId, projectId);	
			
			if(updated)	{
					return getEmployeeById(empId);
			}
			else	{
				throw new DBDataNotModifiedException("", "update", "project id");
			}
		}
		else	{
			
			return null;
		}
		
	}
	//.......................... getListOfEmployeesInProject ..........................

	@Override
	public List<Employee> getListOfEmployeesInProject(int projectId) {
		
		List<Employee> listOfEmployees = employeeRepository.getListOfEmployeesInProject(projectId);
			if(listOfEmployees.size() > 0)	{
				return listOfEmployees;
			}
			else	{
				return null;
			}
		}
	
	//.......................... deleteEmployee ..........................

	@Override
	public boolean deleteEmployee(int empId) throws DBDataNotModifiedException {
	
		if(employeeRepository.existsById(empId))	{	// If Employee data in DB
			employeeRepository.deleteById(empId);
		}
		else	{
			
			return false;
		}
		
		
		//After deletion check if still exist
		if(employeeRepository.existsById(empId))	{			
			throw new DBDataNotModifiedException("", "delete", "employee");
		}
		
		else {
			return true;
		}
	}

}