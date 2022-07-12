package com.maven.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maven.demo.dto.BasicEmployeeDetailsResponseDTO;
import com.maven.demo.dto.HR_EmployeesResponseDTO;
import com.maven.demo.dto.ProjectWithEmployeeResponseDTO;
import com.maven.demo.model.Employee;
import com.maven.demo.model.Project;

@Component
public class FormatDTO {
	
	
	//.............................. formatEmployeeResponseDTO ..............................

	
	public HR_EmployeesResponseDTO formatEmployeeResponseDTO(Employee employee) {
		
		HR_EmployeesResponseDTO responseDTO = new HR_EmployeesResponseDTO();
		
		responseDTO.setEmpId(employee.getEmpId());
		responseDTO.setName(employee.getName());
		responseDTO.setDateOfBirth(employee.getDateOfBirth());
		responseDTO.setMobileNumber(employee.getMobileNumber());
		responseDTO.setEmail(employee.getEmail());
		responseDTO.setAddress(employee.getAddress());
		responseDTO.setBankAcc(employee.getBankAcc());
		responseDTO.setDesignation(employee.getDesignation());
		responseDTO.setSalary(employee.getSalary());
		responseDTO.setDependentList(employee.getDependentList());
		responseDTO.setLaptop(employee.getLaptop());

		return responseDTO;
	}
	
	
	//......................... formatProjectWithEmployeeResponseDTO ........................
	
	
	public ProjectWithEmployeeResponseDTO formatProjectWithEmployeeResponseDTO(Project project) {
		
		ProjectWithEmployeeResponseDTO responseDTO = new ProjectWithEmployeeResponseDTO();
		
		responseDTO.setProjectId(project.getProjectId());
		responseDTO.setName(project.getName());
		responseDTO.setCost(project.getCost());
		responseDTO.setStartDate(project.getStartDate());
		responseDTO.setEndDate(project.getEndDate());
		responseDTO.setComments(project.getComments());	
		
		//Format projectLeader
		Employee projectLeader = project.getProjectLeader();
		
		if(projectLeader != null)	{
			BasicEmployeeDetailsResponseDTO formattedProjectLeader = formatBasicEmployeeDetailsResponseDTO(projectLeader);
			responseDTO.setProjectLeader(formattedProjectLeader);
		}
		
		//Format List<Employee> in project
		List<Employee> originalListOfEmployee = project.getListOfEmployees();
		
		List<BasicEmployeeDetailsResponseDTO> formattedListOfEmployee = new ArrayList<BasicEmployeeDetailsResponseDTO>();
		
		if(originalListOfEmployee == null)	{
			responseDTO.setListOfEmployees(formattedListOfEmployee);	
		}
		
		else if(originalListOfEmployee.size() > 0)	{

			for(Employee employee : originalListOfEmployee) {
				BasicEmployeeDetailsResponseDTO formattedEmployee = formatBasicEmployeeDetailsResponseDTO(employee);
				formattedListOfEmployee.add(formattedEmployee);
			}

			responseDTO.setListOfEmployees(formattedListOfEmployee);	
		}

		return responseDTO;
	}
	
	
	//........................ formatBasicEmployeeDetailsResponseDTO ........................

	
	public BasicEmployeeDetailsResponseDTO formatBasicEmployeeDetailsResponseDTO(Employee employee)	{
		
		BasicEmployeeDetailsResponseDTO responseDTO = new BasicEmployeeDetailsResponseDTO();

		responseDTO.setEmpId(employee.getEmpId());
		responseDTO.setName(employee.getName());
		responseDTO.setEmail(employee.getEmail());
		responseDTO.setDesignation(employee.getDesignation());
		
		return responseDTO;
	}

}