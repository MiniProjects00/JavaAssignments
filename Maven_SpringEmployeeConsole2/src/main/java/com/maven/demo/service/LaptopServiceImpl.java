package com.maven.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.DatabaseTableEmptyException;
import com.maven.demo.exception.LaptopStillLoanedOutException;
import com.maven.demo.model.Laptop;
import com.maven.demo.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService{

	
	@Autowired
	LaptopRepository laptopRepository;

	
	@Override
	public Laptop addLaptop(Laptop laptop)	{
		
		Laptop savedLaptop = laptopRepository.save(laptop);
		
		return savedLaptop;
	}

	
	@Override
	public List<Laptop> getAllLaptops() throws DatabaseTableEmptyException {
		
		List<Laptop> listOfLaptops = laptopRepository.findAll();
		
		if (listOfLaptops.size() > 0)	{
			return listOfLaptops;
		}
	
		else {
			throw new DatabaseTableEmptyException("", "Laptop");
		}
	}
	

	@Override
	public Laptop getLaptopById(int laptopId) {
		
		if(laptopRepository.existsById(laptopId))	{
			
			Laptop laptopRetrieved = laptopRepository.findById(laptopId).get();
			
			return laptopRetrieved;
		}

		else	{
			throw new NoSuchElementException();
		}
	}

	
	@Override
	public List<Laptop> getLaptopByAvailabilityStatus(boolean status) {
		
		List<Laptop> listOfLaptops = laptopRepository.getLaptopByAvailabilityStatus(status);
		
		if(listOfLaptops.size() > 0)	{
			return listOfLaptops;
		}
		
		else {
			throw new NoResultException();
		}
	}


	@Override
	public boolean updateLaptopAvailability(int laptopId, boolean isAvailable) throws DBDataNotModifiedException {
		
		if(laptopRepository.existsById(laptopId))	{	
			
			Laptop laptopRetrieved = laptopRepository.findById(laptopId).get();
			
			laptopRetrieved.setAvailable(isAvailable);
			
			Laptop laptopSaved = laptopRepository.save(laptopRetrieved);
			
			if(laptopSaved.isAvailable() == isAvailable)	{
				return true;
			}
			
			else	{
				throw new DBDataNotModifiedException("", "Laptop");
			}
		}
		
		else	{
			throw new NoSuchElementException();
		}
	}

	
	@Override
	public boolean deleteLaptop(int laptopId) throws DBDataNotModifiedException, LaptopStillLoanedOutException {
	
		if(laptopRepository.existsById(laptopId))	{	
			
			Laptop laptopRetrieved = laptopRepository.findById(laptopId).get();
			
			if(laptopRetrieved.isAvailable() == false) {
				throw new LaptopStillLoanedOutException("", laptopId);
			}
			
			else	{
				laptopRepository.deleteById(laptopId);
			}
		}
		
		else	{
			throw new NoSuchElementException();
		}
		
		
		//After deletion check if still exist
		if(laptopRepository.existsById(laptopId))	{			
			throw new DBDataNotModifiedException("", "Laptop");
		}
		
		else {
			return true;
		}
	}
	
}