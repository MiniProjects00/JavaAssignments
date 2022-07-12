package com.maven.demo.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.maven.demo.model.Address;
import com.maven.demo.model.Dependent;

@Component
public class ValidateEmployee {

	
	//........................... validateFilterRange ...........................
	
	
	public boolean validateFilterRange(int min, int max)	{
		
		if((min < 0) || (max <=0))	{
			return false;
		}
		
		else if(min > max)	{
			return false;
		}
		
		else return true;
	}
	
	
	//........................... validateDependent .............................

	
	public boolean validateDependent(List<Dependent> dependentList)	{
		
		for(Dependent dependent : dependentList)	{
			
			String name = dependent.getName();
			if(name != null)	{
				if(name.equals(""))	{
					return false;
				
				}
			}
			else	{
				return false;
			}
			
			String relationship = dependent.getRelationship();
			if(relationship != null)	{
				if(relationship.equals(""))	{
					return false;
				}
			}
			
			else	{
				return false;
			}
		}
		
		return true;
	}
	
	
	//........................... validateFilterRange ...........................

	
	public boolean validateAddress(Address address)	{
		
		String blockNumber = address.getBlockNumber();
		if(blockNumber != null)	{
			if(blockNumber.equals(""))	{
				return false;
			}
		}
		
		else	{
			return false;
		}
		
		String streetName = address.getStreetName();
		if(streetName != null)	{
			if(streetName.equals(""))	{
				return false;
			}
		}
		
		else	{
			return false;
		}
		
		long postalCode = address.getPostalCode();
		if(postalCode == 0)	{
			return false;
		}
		
		String country = address.getCountry();
		
		if(country != null)	{
			if(country.equals(""))	{
				return false;
			}
		}
		
		else	{
			return false;
		}
		
		return true;
	}
	
}