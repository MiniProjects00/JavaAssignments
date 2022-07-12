package com.maven.demo.web;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maven.demo.dto.HR_EmployeesResponseDTO;
import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.DatabaseTableEmptyException;
import com.maven.demo.exception.EmbeddedFieldCannotBeEmptyException;
import com.maven.demo.exception.InvalidFilterRangeException;
import com.maven.demo.exception.LaptopNotAssignedToEmployeeException;
import com.maven.demo.exception.LaptopNotAvailableException;
import com.maven.demo.model.Address;
import com.maven.demo.model.Dependent;
import com.maven.demo.model.Employee;
import com.maven.demo.service.EmployeeService;
import com.maven.demo.service.LaptopService;
import com.maven.demo.service.ProjectService;
import com.maven.demo.util.FormatDTO;

@Component																	
@Validated
@RestController
@RequestMapping("employeeConsole/hr")
public class EmployeeRestController {

	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired 
	ProjectService projectService;
	
	@Autowired 
	LaptopService laptopService;
	
	@Autowired
	FormatDTO formatDto;
	
	
	public EmployeeRestController()	{
		System.out.println("EmployeeController constructor created");
	}


	@PostMapping("/employee/add")
	public ResponseEntity<HR_EmployeesResponseDTO> addEmployee(@RequestBody @Valid Employee employee) throws EmbeddedFieldCannotBeEmptyException {
		
		Employee savedEmployee = employeeService.addEmployee(employee);
		
		HR_EmployeesResponseDTO responseDto = formatDto.formatEmployeeResponseDTO(savedEmployee);
		
		return new ResponseEntity<HR_EmployeesResponseDTO>(responseDto,HttpStatus.OK);
	}


	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() throws DatabaseTableEmptyException {
		
		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(listOfEmployees,HttpStatus.OK);
	}
	
	
	@GetMapping("/employee/{id}")											
	public ResponseEntity<HR_EmployeesResponseDTO> getEmployeeById(@PathVariable int id) {				
		
		Employee employee =  employeeService.getEmployeeById(id);
		
		HR_EmployeesResponseDTO responseDto = formatDto.formatEmployeeResponseDTO(employee);
		
		return new ResponseEntity<HR_EmployeesResponseDTO>(responseDto,HttpStatus.OK);
	}


	@GetMapping("/employee")																	
	public ResponseEntity<HR_EmployeesResponseDTO> getEmployeeByName(@RequestParam String name) {	
		
		Employee employee = employeeService.getEmployeeByName(name);
		
		HR_EmployeesResponseDTO responseDto = formatDto.formatEmployeeResponseDTO(employee);
		
		return new ResponseEntity<HR_EmployeesResponseDTO>(responseDto,HttpStatus.OK);
	}
	
	
	@GetMapping("/allEmployees/filter")											
	public ResponseEntity<List<HR_EmployeesResponseDTO>> getEmployeesWithinSalaryRange(@RequestParam int minSalary, @RequestParam int maxSalary) throws InvalidFilterRangeException {
		
		List<Employee> listOfEmployees = employeeService.getEmployeesWithinSalaryRange(minSalary, maxSalary);
		
		
		List<HR_EmployeesResponseDTO> responseDto = new ArrayList<HR_EmployeesResponseDTO>();
		
		for(Employee employee : listOfEmployees)	{
			responseDto.add(formatDto.formatEmployeeResponseDTO(employee));
		}
		
		return new ResponseEntity<List<HR_EmployeesResponseDTO>>(responseDto,HttpStatus.OK);
	}
	
	
	@PutMapping("/employee/{empId}/edit/address/upate")				
	public ResponseEntity<HR_EmployeesResponseDTO> updateAddress(@PathVariable int empId, @RequestBody Address address) throws DBDataNotModifiedException, EmbeddedFieldCannotBeEmptyException {

		Employee employeeUpdated = employeeService.updateAddress(empId, address);
		
		HR_EmployeesResponseDTO responseDTO = formatDto.formatEmployeeResponseDTO(employeeUpdated);
		
		return new ResponseEntity<HR_EmployeesResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	
	@PutMapping("/employee/{empId}/edit/project/add")				
	public ResponseEntity<Employee> assignProjectToEmployee(@PathVariable int empId, @RequestParam int projectId) throws DBDataNotModifiedException {
		
		Employee employeeUpdated = employeeService.assignProjectToEmployee(empId, projectId);
		
		return new ResponseEntity<Employee>(employeeUpdated,HttpStatus.OK);
	}
	
	
	@PutMapping("/employee/{empId}/edit/project/unassign")				
	public ResponseEntity<Employee> unassignProject(@PathVariable int empId, @RequestParam int projectId) throws DBDataNotModifiedException {
		
		Employee employeeUpdated = employeeService.unassignProject(empId, projectId);
		
		return new ResponseEntity<Employee>(employeeUpdated,HttpStatus.OK);
	}
	
	
	@PutMapping("/employee/{empId}/edit/dependent/add")				
	public ResponseEntity<HR_EmployeesResponseDTO> addDependentList(@PathVariable int empId, @RequestBody List<Dependent> dependentList) throws EmbeddedFieldCannotBeEmptyException {

		Employee employeeUpdated = employeeService.addDependentList(empId, dependentList);
		
		HR_EmployeesResponseDTO responseDTO = formatDto.formatEmployeeResponseDTO(employeeUpdated);
		
		return new ResponseEntity<HR_EmployeesResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	
	@PutMapping("/employee/{empId}/edit/dependent/remove")				
	public ResponseEntity<HR_EmployeesResponseDTO> removeDependentList(@PathVariable int empId) {

		Employee employeeUpdated = employeeService.removeDependentList(empId);
		
		HR_EmployeesResponseDTO responseDTO = formatDto.formatEmployeeResponseDTO(employeeUpdated);
		
		return new ResponseEntity<HR_EmployeesResponseDTO>(responseDTO,HttpStatus.OK);
	}
	

	@PutMapping("/employee/{empId}/edit/laptop/add")				
	public ResponseEntity<HR_EmployeesResponseDTO> addLaptopDetails(@PathVariable int empId, @RequestParam int laptopId) throws DBDataNotModifiedException, LaptopNotAvailableException {

		Employee employeeUpdated = employeeService.addLaptopDetails(empId, laptopId);
		
		boolean isUpdated = laptopService.updateLaptopAvailability(laptopId, false);
		
		HR_EmployeesResponseDTO responseDTO = formatDto.formatEmployeeResponseDTO(employeeUpdated);
		
		return new ResponseEntity<HR_EmployeesResponseDTO>(responseDTO,HttpStatus.OK);
	}

	
	@PutMapping("/employee/{empId}/edit/laptop/remove")				
	public ResponseEntity<HR_EmployeesResponseDTO> removeLaptopDetails(@PathVariable int empId, @RequestParam int laptopId) throws DBDataNotModifiedException, LaptopNotAssignedToEmployeeException {

		Employee employeeUpdated = employeeService.removeLaptopDetails(empId, laptopId);
		
		HR_EmployeesResponseDTO responseDTO = formatDto.formatEmployeeResponseDTO(employeeUpdated);
		
		return new ResponseEntity<HR_EmployeesResponseDTO>(responseDTO,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/employee/delete")
	public boolean deleteEmployee(@RequestParam int empId) throws DBDataNotModifiedException {
		
		return employeeService.deleteEmployee(empId);
	}
	
}