package com.maven.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maven.demo.dto.AddEmployeeDTO;
import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.IdNotFoundException;
import com.maven.demo.exception.InvalidFilterRangeException;
import com.maven.demo.exception.InvalidInputFormatException;
import com.maven.demo.exception.NoRecordFoundException;
import com.maven.demo.exception.ProjectHasEmployeeException;
import com.maven.demo.exception.SalaryOutOfRangeException;
import com.maven.demo.model.Employee;
import com.maven.demo.model.Project;
import com.maven.demo.service.EmployeeService;
import com.maven.demo.service.ProjectService;


@Component
@RestController
@RequestMapping("employeeConsole/hr")				
public class HREmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired 
	ProjectService projectService;
	
	
	public HREmployeeController()	{
		System.out.println("HREmployeeController constructor created");
	}

	
	//....................................... getAllEmployees .......................................
	
	
	@GetMapping("/allEmployees")
	ResponseEntity<List<Employee>> getAllEmployees() throws NoRecordFoundException {
		
		List<Employee> listOfEmployees = employeeService.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(listOfEmployees,HttpStatus.OK);
	}
	
	
	//...................................... getEmployeeById .......................................

	
	@GetMapping("/employee/{id}")											
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) throws NoRecordFoundException	{				
		
		Employee employeeRetrieved =  employeeService.getEmployeeById(id);
		
		return new ResponseEntity<Employee>(employeeRetrieved,HttpStatus.OK);
	}

	
	//...................................... getEmployeeByName .......................................

	
	@GetMapping("/employee")																	
	public ResponseEntity<Employee> getEmployeeByName(@RequestParam String name) throws NoRecordFoundException	{	
		
		Employee employeeRetrieved = employeeService.getEmployeeByName(name);
		
		return new ResponseEntity<Employee>(employeeRetrieved,HttpStatus.OK);

	}
	
	
	//.................................. assignProjectToEmployee ...................................

	
	@PutMapping("/employee/{empId}/edit/addProject")				
	public ResponseEntity<Employee> assignProjectToEmployee(@PathVariable int empId, @RequestParam int projectId) throws DBDataNotModifiedException, NoRecordFoundException	{
		
		Employee employeeUpdated = employeeService.assignProjectToEmployee(empId, projectId);
		
		return new ResponseEntity<Employee>(employeeUpdated,HttpStatus.OK);

	}
	
	
	//.................................. getEmployeeWithinSalaryRange .................................


	@GetMapping("/allEmployees/filter")											
	ResponseEntity<List<Employee>> getEmployeesWithinSalaryRange(@RequestParam int minSalary, @RequestParam int maxSalary) throws NoRecordFoundException, InvalidFilterRangeException	{
		
		List<Employee> listOfEmployees = employeeService.getEmployeesWithinSalaryRange(minSalary, maxSalary);
		
		return new ResponseEntity<List<Employee>>(listOfEmployees,HttpStatus.OK);

	}
	
	//...................................... getEmployeesInProject ......................................
	

	@GetMapping("allEmployees/project/{projectId}")
	ResponseEntity<List<Employee>> getListOfEmployeesInProject(@PathVariable int projectId) {

		List<Employee> listOfEmployees = employeeService.getListOfEmployeesInProject(projectId);
		
		return new ResponseEntity<List<Employee>>(listOfEmployees,HttpStatus.OK);
	}
	
	
	//.......................................... addEmployee ..........................................

	
	@PostMapping("/employee/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody AddEmployeeDTO empDTO)throws SalaryOutOfRangeException, IdNotFoundException, InvalidInputFormatException, NoRecordFoundException {
		
		Employee savedEmployee = employeeService.addEmployee(empDTO);
		
		return new ResponseEntity<Employee>(savedEmployee,HttpStatus.OK);
		
	}
	
	//.......................................... deleteEmployee ..........................................

	
	@DeleteMapping("/employee/delete")
	public boolean deleteEmployee(@RequestParam int empId) throws DBDataNotModifiedException, NoRecordFoundException {
		
		boolean status = employeeService.deleteEmployee(empId);
		return (status)?true:false;
	}
	
	
	//****************************************************************************************************************
	
	
	//.......................................... addProject ..........................................
	
	@PostMapping("/project/add")
	public ResponseEntity<Project> addProject(@RequestBody Project project)throws InvalidInputFormatException {
			
		Project savedProject = projectService.addProject(project);
			
		return new ResponseEntity<Project>(savedProject,HttpStatus.OK);
			
		}
	
	//.......................................... getProjectById ..........................................
	
	@GetMapping("/project/{projectId}")
	public ResponseEntity<Project> getProjectById(@PathVariable int projectId) {
			
		Project projectRetrieved = projectService.getProjectById(projectId);
			
		return new ResponseEntity<Project>(projectRetrieved,HttpStatus.OK);

		}
	
	//.......................................... getProjectByName ..........................................

	@GetMapping("/project")
	public ResponseEntity<Project> getProjectByName(@RequestParam String projectName) {
			
		Project projectRetrieved = projectService.getProjectByName(projectName);
			
		return new ResponseEntity<Project>(projectRetrieved,HttpStatus.OK);

		}
	//.......................................... getAllProjects ..........................................

	@GetMapping("/allProjects")
	ResponseEntity<List<Project>> getAllProjects() throws NoRecordFoundException  {
			
		List<Project> listOfProjects = projectService.getAllProjects();
		
		return new ResponseEntity<List<Project>>(listOfProjects,HttpStatus.OK);
	}
	//.......................................... updateProjectName ..........................................

	@PutMapping("/project/{projectId}/edit/name")
	public ResponseEntity<Project> updateProjectName(@PathVariable int projectId, @RequestParam String newProjectName) throws DBDataNotModifiedException {
			
		Project projectUpdated = projectService.updateProjectName(projectId, newProjectName);
			
		return new ResponseEntity<Project>(projectUpdated,HttpStatus.OK);
	}

	//.......................................... deleteProject ..........................................

	@DeleteMapping("/project/delete")
	public boolean deleteProject(@RequestParam int projectId)  throws DBDataNotModifiedException, ProjectHasEmployeeException, NoRecordFoundException {
			
		boolean status = projectService.deleteProject(projectId);
		return (status)?true:false;
	}
}
