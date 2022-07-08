package com.maven.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maven.demo.dto.AddEmployeeDTO;


@Component
public class ValidateEmployee {

/*	public boolean validateEmployeeSalary(Employee e) throws SalaryOutOfRangeException, MandatoryFieldMissingException {
		
		int salary = e.getSalary();
		
		if(salary == 0) {
			throw new MandatoryFieldMissingException("", "Salary", "");
		}
		
		String designation = e.getDesignation();
		
		//Executive salary cannot be > 5000
		if(designation.equalsIgnoreCase("executive") && salary <= 5000)	{
			return true;
		}
		else {
			return false;
		}
	}
*/
	public List<String> validateEmployeeInputFields(AddEmployeeDTO empDTO) {
		
		List<String> fieldsMissing = new ArrayList<String>();
	
		//~~~~ Name ~~~~
		String name = empDTO.getName();
		boolean status = validateEmployeeName(name);
		if(!status)	{
			fieldsMissing.add("name");
		}
		
		//~~~~ Email ~~~~
		String email = empDTO.getEmail();
		status = validateEmployeeEmail(email);
		if(!status)	{
			fieldsMissing.add("email");
		}
		
		//~~~~ Address ~~~~
		String address = empDTO.getAddress();
		status = validateEmployeeAddress(address);
		if(!status)	{
			fieldsMissing.add("address");
		}
		
		//~~~~ Bank Account Number ~~~~
		int bankAccNum = empDTO.getBankAcc();
		status = validateEmployeeBankAccNumber(bankAccNum);
		if(!status)	{
			fieldsMissing.add("Bank Account Number");
		}
		
		//~~~~ Designation ~~~~
		String designation = empDTO.getDesignation();
		status = validateEmployeeDesignation(designation);
		if(!status)	{
			fieldsMissing.add("Designation");
		}
		
		//~~~~ Salary ~~~~
		int salary = empDTO.getSalary();
		status = validateEmployeeSalary(salary);
		if(!status)	{
			fieldsMissing.add("Salary");
		}
		
		return fieldsMissing;
		
	}
	
	public boolean validateEmployeeName(String name) {
		if(name == null)	{
			return false;
		}
		else	{
			return true;
		}
	}

	public boolean validateEmployeeEmail(String email) {
		if(email == null)	{
			return false;
		}
		else	{
			return true;
		}
	}
	
	public boolean validateEmployeeAddress(String address) {
		if(address == null)	{
			return false;
		}
		else	{
			return true;
		}
	}
	
	public boolean validateEmployeeBankAccNumber(int bankAccNum) {
		if(bankAccNum == 0)	{
			return false;
		}
		else	{
			return true;
		}
	}
	
	public boolean validateEmployeeDesignation(String designation) {
		if(designation == null)	{
			return false;
		}
		else	{
			return true;
		}
	}
	
	public boolean validateEmployeeSalary(int salary) {
		if(salary == 0)	{
			return false;
		}
		else	{
			return true;
		}
	}
	
	public boolean validateFilterRange(int min, int max)	{
		
		if((min < 0) || (max <=0))	{
			return false;
		}
		
		else if(min > max)	{
			return false;
		}
		
		else return true;
	}
	
}
