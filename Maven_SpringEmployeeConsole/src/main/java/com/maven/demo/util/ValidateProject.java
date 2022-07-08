package com.maven.demo.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.maven.demo.model.Project;


@Component
public class ValidateProject {
	
	public List<String> validateProjectInputFields(Project p) {
		
		List<String> fieldsMissing = new ArrayList<String>();

		//~~~~ Project Id ~~~~
		int id = p.getProjectId();
		boolean status = validateProjectId(id);
		if(!status)	{
			fieldsMissing.add("id");
		}
		
		//~~~~ Name ~~~~
		String name = p.getName();
		status = validateProjectName(name);
		if(!status)	{
			fieldsMissing.add("name");
		}
		
		//~~~~ Cost ~~~~
		int cost = p.getCost();
		status = validateProjectCost(cost);
		if(!status)	{
			fieldsMissing.add("cost");
		}
		
		//~~~~ Start date ~~~~
		String startDate = p.getStartDate();
		String endDate = p.getEndDate();
		status = validateProjectDate(startDate, endDate);
		if(!status)	{
			fieldsMissing.add("date");
		}
		
		//~~~~ Bank Account Number ~~~~
		String email = p.getHeadEmail();
		status = validateProjectHeadEmail(email);
		if(!status)	{
			fieldsMissing.add("project head email");
		}
		
		return fieldsMissing;
		
	}
	
	public boolean validateProjectId(int id) {
		if(id == 0)	{
			return false;
		}
		else	{
			return true;
		}
	}
	
	public boolean validateProjectName(String name) {
		if(name == null || name == "")	{
			return false;
		}
		else	{
			return true;
		}
	}
	
	public boolean validateProjectCost(int cost) {
		if(cost == 0)	{
			return false;
		}
		else	{
			return true;
		}
	}
	
	public boolean validateProjectDate(String startDate, String endDate) {
		if(startDate==null || endDate==null || startDate=="" || endDate=="")	{
			return false;
		}
		else	{
			return true;
		}
	}
	
	public boolean validateProjectHeadEmail(String email) {
		if(email == null || email == "")	{
			return false;
		}
		else	{
			return true;
		}
	}
	
}
