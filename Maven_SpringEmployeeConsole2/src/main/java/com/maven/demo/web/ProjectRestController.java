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

import com.maven.demo.dto.ProjectWithEmployeeResponseDTO;
import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.DatabaseTableEmptyException;
import com.maven.demo.exception.ProjectHasEmployeeException;
import com.maven.demo.model.Employee;
import com.maven.demo.model.Project;
import com.maven.demo.service.EmployeeService;
import com.maven.demo.service.ProjectService;
import com.maven.demo.util.FormatDTO;

@Component		
@Validated 	
@RestController
@RequestMapping("employeeConsole/hr")
public class ProjectRestController {

	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	FormatDTO formatDto;
	

	//.......................................... addProject ..........................................

	
	@PostMapping("/project/add")
	public ResponseEntity<Project> addProject(@RequestBody @Valid Project project) {
			
		Project savedProject = projectService.addProject(project);

		return new ResponseEntity<Project>(savedProject,HttpStatus.OK);
	}
	
	
	//........................................ getAllProjects ........................................

	
	@GetMapping("/allProjects")
	public ResponseEntity<List<ProjectWithEmployeeResponseDTO>> getAllProjects() throws DatabaseTableEmptyException  {
			
		List<Project> listOfProjects = projectService.getAllProjects();
		
		List<ProjectWithEmployeeResponseDTO> customDTOList = new ArrayList<ProjectWithEmployeeResponseDTO>();
		
		if(listOfProjects.size() > 0)	{
			
			for(Project project : listOfProjects)	{
				
				ProjectWithEmployeeResponseDTO customDTO = formatDto.formatProjectWithEmployeeResponseDTO(project);
				
				customDTOList.add(customDTO);
			}
		}

		return new ResponseEntity<List<ProjectWithEmployeeResponseDTO>>(customDTOList,HttpStatus.OK);
	}
		
	
	//........................................ getProjectById ........................................

	
	@GetMapping("/project/{projectId}")
	public ResponseEntity<ProjectWithEmployeeResponseDTO> getProjectById(@PathVariable int projectId) {
			
		Project projectRetrieved = projectService.getProjectById(projectId);
		
		ProjectWithEmployeeResponseDTO customDTO = formatDto.formatProjectWithEmployeeResponseDTO(projectRetrieved);
		
		return new ResponseEntity<ProjectWithEmployeeResponseDTO>(customDTO,HttpStatus.OK);
	}
	
	
	//....................................... getProjectByName .......................................


	@GetMapping("/project")
	public ResponseEntity<ProjectWithEmployeeResponseDTO> getProjectByName(@RequestParam String projectName) {
			
		Project projectRetrieved = projectService.getProjectByName(projectName);
		
		ProjectWithEmployeeResponseDTO customDTO = formatDto.formatProjectWithEmployeeResponseDTO(projectRetrieved);

		return new ResponseEntity<ProjectWithEmployeeResponseDTO>(customDTO,HttpStatus.OK);
	}
	
	
	//....................................... updateProjectName ......................................

	
	@PutMapping("/project/{projectId}/edit/name")
	public ResponseEntity<ProjectWithEmployeeResponseDTO> updateProjectName(@PathVariable int projectId, @RequestParam String newProjectName) throws DBDataNotModifiedException {
			
		Project projectUpdated = projectService.updateProjectName(projectId, newProjectName);
		
		ProjectWithEmployeeResponseDTO customDTO = formatDto.formatProjectWithEmployeeResponseDTO(projectUpdated);
			
		return new ResponseEntity<ProjectWithEmployeeResponseDTO>(customDTO,HttpStatus.OK);
	}
	
	
	//..................................... updateProjectDetails .....................................

	
	@PutMapping("/project/{projectId}/edit")
	public ResponseEntity<ProjectWithEmployeeResponseDTO> updateProjectDetails(@PathVariable int projectId, @RequestBody Project projectDetailsToUpdate) throws DBDataNotModifiedException {
		
		Project projectUpdated = projectService.updateProjectDetails(projectId, projectDetailsToUpdate);
		
		ProjectWithEmployeeResponseDTO customDTO = formatDto.formatProjectWithEmployeeResponseDTO(projectUpdated);

		return new ResponseEntity<ProjectWithEmployeeResponseDTO>(customDTO,HttpStatus.OK);
	}
		
	
	//...................................... assignProjectLeader .....................................


	@PutMapping("/project/{projectId}/edit/projectLeader")
	public ResponseEntity<ProjectWithEmployeeResponseDTO> assignProjectLeader(@PathVariable int projectId, @RequestParam int empId) throws DBDataNotModifiedException {
		
		Project projectUpdated = projectService.assignProjectLeader(projectId, empId);
		
		//Add employee to project
		Employee employeeAdded = employeeService.assignProjectToEmployee(empId, projectId);
		
		//Retrieve project object after adding employee to project
		Project projectRetrieved = projectService.getProjectById(projectId);

		ProjectWithEmployeeResponseDTO customDTO = formatDto.formatProjectWithEmployeeResponseDTO(projectRetrieved);
		
		return new ResponseEntity<ProjectWithEmployeeResponseDTO>(customDTO,HttpStatus.OK);
	}
	
	
	//..................................... unassignProjectLeader ....................................

	
	@PutMapping("/project/{projectId}/edit/projectLeader/unassign")
	public ResponseEntity<ProjectWithEmployeeResponseDTO> unassignProjectLeader(@PathVariable int projectId) throws DBDataNotModifiedException {
		
		Project projectUpdated = projectService.unassignProjectLeader(projectId);
		
		ProjectWithEmployeeResponseDTO customDTO = formatDto.formatProjectWithEmployeeResponseDTO(projectUpdated);

		return new ResponseEntity<ProjectWithEmployeeResponseDTO>(customDTO,HttpStatus.OK);
	}
	
	
	//.........................................deleteProject .........................................

	
	@DeleteMapping("/project/delete")
	public boolean deleteProject(@RequestParam int projectId)  throws DBDataNotModifiedException, ProjectHasEmployeeException {
			
		boolean status = projectService.deleteProject(projectId);
		
		return status;
	}
	
}