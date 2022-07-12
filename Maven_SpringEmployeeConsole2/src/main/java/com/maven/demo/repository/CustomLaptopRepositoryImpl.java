package com.maven.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.demo.model.Laptop;

@Service
@Transactional
public class CustomLaptopRepositoryImpl implements CustomLaptopRepository {
	
	
	//Create session object in hibernate 
	@Autowired
	EntityManager springDataJPA;
	
	
	//........................ getLaptopByAvailabilityStatus ........................

	
	@Override
	public List<Laptop> getLaptopByAvailabilityStatus(boolean status) {
		
		int intStatus = 0;
		
		if(status)	{
			intStatus = 1;
		}
		
		String query = "from Laptop where is_available = :intStatus";

		Query q = springDataJPA.createQuery(query,Laptop.class);
		q.setParameter("intStatus", intStatus);
		
		List<Laptop> resultList = q.getResultList();
		
		return resultList;
	}
	
}