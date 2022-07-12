package com.maven.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.DatabaseTableEmptyException;
import com.maven.demo.exception.EmbeddedFieldCannotBeEmptyException;
import com.maven.demo.exception.InvalidFilterRangeException;
import com.maven.demo.exception.LaptopNotAssignedToEmployeeException;
import com.maven.demo.exception.LaptopNotAvailableException;
import com.maven.demo.model.Address;
import com.maven.demo.model.Dependent;
import com.maven.demo.model.Employee;
import com.maven.demo.model.Laptop;
import com.maven.demo.model.Project;
import com.maven.demo.repository.EmployeeRepository;
import com.maven.demo.repository.LaptopRepository;
import com.maven.demo.repository.ProjectRepository;
import com.maven.demo.util.ValidateEmployee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	LaptopRepository laptopRepository;
	
	@Autowired
	LaptopService laptopService;
	
	@Autowired
	ValidateEmployee validateEmployee;

	
	//........................... addEmployee ...........................
	
	
	@Override
	public Employee addEmployee(Employee employee) throws EmbeddedFieldCannotBeEmptyException {
		
		String employeeName = employee.getName();
		
		if(employeeName.contains(" "))	{
			employeeName = employeeName.replace(" ", "_");
			employee.setName(employeeName);
		}
		
		Address employeeAddress = employee.getAddress();
		
		boolean status = validateEmployee.validateAddress(employeeAddress);
		
		if(status) {
			Employee savedEntity =  employeeRepository.save(employee);
			return savedEntity;
		}
		
		else	{
			throw new EmbeddedFieldCannotBeEmptyException();
		}
	}

	
	//.......................... getAllEmployees .........................

	
	@Override
	public List<Employee> getAllEmployees() throws DatabaseTableEmptyException{
		
		List<Employee> listOfEmployees = employeeRepository.findAll();
		
		if (listOfEmployees.size() > 0)	{
			return listOfEmployees;
		}
		
		else {
			throw new DatabaseTableEmptyException("", "Employee");
		}
	}

	
	//.......................... getEmployeeById .........................

	
	@Override
	public Employee getEmployeeById(int empId) {
		
		Employee employeeReturned =  employeeRepository.findById(empId).get();
		
		if(employeeReturned != null)	{
			return employeeReturned;
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}

	
	//......................... getEmployeeByName ........................
	

	@Override
	public Employee getEmployeeByName(String empName) {
		
		Employee employeeReturned =  employeeRepository.getEmployeeByName(empName);
		
		if(employeeReturned != null)	{
			return employeeReturned;
		}
		
		else {
			throw new NoResultException();
		}
	}
	
	
	//................... getEmployeesWithinSalaryRange ..................


	@Override
	public List<Employee> getEmployeesWithinSalaryRange(int minSalary, int maxSalary) throws InvalidFilterRangeException {
		
		boolean rangeValid = validateEmployee.validateFilterRange(minSalary, maxSalary);
		
		if(rangeValid)	{
			
			List<Employee> listOfEmployees = employeeRepository.getEmployeesWithinSalaryRange(minSalary, maxSalary);
			
			if(listOfEmployees.size() > 0)	{
				return listOfEmployees;
			}
			
			else	{
				throw new NoResultException();
			}
		}
		
		else {
			throw new InvalidFilterRangeException("", "salary", minSalary, maxSalary);
		}
	}
	
	
	//.................... getListOfEmployeesInProject ...................

	
	@Override
	public List<Employee> getListOfEmployeesInProject(int projectId) {
		
		List<Employee> listOfEmployees = employeeRepository.getListOfEmployeesInProject(projectId);
			
		if(listOfEmployees.size() > 0)	{
			return listOfEmployees;
		}
			
		else	{
			throw new NoResultException();
		}
	}
	
	
	//........................... updateAddress ..........................

	
	@Override
	public Employee updateAddress(int empId, Address address) throws EmbeddedFieldCannotBeEmptyException {

		if(employeeRepository.existsById(empId))	{	
	
			Employee employee = employeeRepository.findById(empId).get();
			
			boolean status = validateEmployee.validateAddress(address);

			if(status)	{
				
				employee.setAddress(address);
				Employee employeeSaved = employeeRepository.save(employee);
			
				return employeeSaved;
			}
			
			else	{
				throw new EmbeddedFieldCannotBeEmptyException();
			}
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}
		
	
	//...................... assignProjectToEmployee .....................

	
	@Override
	public Employee assignProjectToEmployee(int empId, int projectId) throws DBDataNotModifiedException {
		
		if(employeeRepository.existsById(empId) && projectRepository.existsById(projectId))	{
			
			//Update Employee table
			boolean updated = employeeRepository.assignEmployeeToProject(empId, projectId);	
			
			if(updated)	{
				return getEmployeeById(empId);
			}
			
			else	{
				throw new DBDataNotModifiedException("", "Employee");
			}
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}
	
	
	//.......................... unassignProject .........................

	
	@Override
	public Employee unassignProject(int empId, int projectId) throws DBDataNotModifiedException {
		
		if(employeeRepository.existsById(empId))	{
			
			boolean updated = employeeRepository.unassignProject(empId);	
			
			//If applicable, also remove employee as project leader
			Project project = projectRepository.findById(projectId).get();
			
			if(project.getProjectLeader() != null)	{
				
				if(project.getProjectLeader().getEmpId() == empId) {
					
					project.setProjectLeader(null);
				
					projectRepository.save(project);
				}
			}
			
			if(updated)	{
				return getEmployeeById(empId);
			}
			
			else	{
				throw new DBDataNotModifiedException("", "Employee");
			}
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}

	
	//......................... addDependentList .........................

	
	@Override
	public Employee addDependentList(int empId, List<Dependent> dependentList) throws EmbeddedFieldCannotBeEmptyException {
		
		if(employeeRepository.existsById(empId))	{	
			
			Employee employee = employeeRepository.findById(empId).get();
			
			List<Dependent> dependentListFromDB = employee.getDependentList();
			
			if(dependentList.size() > 0 || dependentList!=null) {
				
				boolean status = validateEmployee.validateDependent(dependentList);
				
				if(status == false)	{
					throw new EmbeddedFieldCannotBeEmptyException();
				}
				
				else {
					
					//Retrieve names of all dependents already saved in DB
					List<String> listOfDependentNameInDB = new ArrayList<String>();
					
					for(Dependent dependentInDB : dependentListFromDB )	{
						listOfDependentNameInDB.add(dependentInDB.getName());
					}
					
					//Add dependents into Set if does not exist in DB
					for(Dependent newDependent : dependentList)	{
						
						String newDependentName = newDependent.getName();
						
						if(listOfDependentNameInDB.contains(newDependentName) == false)	{
							dependentListFromDB.add(newDependent);
						}
					}
				}
			}
			
			employee.setDependentList(dependentListFromDB);
			
			employeeRepository.save(employee);
			
			return employee;
		}

		else	{
			throw new NoSuchElementException();
		}
	}
	
	
	//........................ removeDependentList .......................

	
	@Override
	public Employee removeDependentList(int empId) {

		Employee employee = employeeRepository.findById(empId).get();
		
		employee.setDependentList(new ArrayList<Dependent>());
		
		Employee employeeSaved = employeeRepository.save(employee);

		return employeeSaved;
	}
	
	
	//......................... addLaptopDetails .........................

	
	@Override
	public Employee addLaptopDetails(int empId, int laptopId) throws LaptopNotAvailableException  {
		
		if(employeeRepository.existsById(empId))	{	
			
			if(laptopRepository.existsById(laptopId))	{	

				Laptop laptopObject = laptopRepository.findById(laptopId).get();
				
				if(!laptopObject.isAvailable()) {
					throw new LaptopNotAvailableException("", laptopId);
				}
				
				else	{
					Employee employee = employeeRepository.findById(empId).get();
					
					employee.setLaptop(laptopObject);
					
					employeeRepository.save(employee);
					
					return employee;
				}
			}
			
			else	{
				throw new NoSuchElementException();
			}
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}
	
	
	//........................ removeLaptopDetails .......................

	
	@Override
	public Employee removeLaptopDetails(int empId, int laptopId) throws DBDataNotModifiedException, LaptopNotAssignedToEmployeeException {
		
		if(employeeRepository.existsById(empId) && laptopRepository.existsById(laptopId))	{	
			
			Employee employee = employeeRepository.findById(empId).get();
			
			if(employee.getLaptop().getLaptopId() == laptopId)	{
				
				employee.setLaptop(null);
				
				laptopService.updateLaptopAvailability(laptopId, true);
				
				return employee;
			}
			
			else	{
				throw new LaptopNotAssignedToEmployeeException("", empId);
			}
		}	
		
		else	{
			throw new NoSuchElementException();
		}
	}
	
	
	//.......................... deleteEmployee ..........................

	
	@Override
	public boolean deleteEmployee(int empId) throws DBDataNotModifiedException {
	
		if(employeeRepository.existsById(empId))	{	
			
			//Return laptop, if applicable
			Employee employeeRetrieved = employeeRepository.findById(empId).get();
			
			if(employeeRetrieved.getLaptop() != null)	{
				
				int laptopId = employeeRetrieved.getLaptop().getLaptopId();
				
				laptopService.updateLaptopAvailability(laptopId, true);
			}
			
			employeeRepository.deleteById(empId);
		}
		
		else	{
			throw new NoSuchElementException();
		}
		
		//After deletion check if still exist
		if(employeeRepository.existsById(empId))	{			
			throw new DBDataNotModifiedException("", "Employee");
		}
		
		else {
			return true;
		}
	}
}