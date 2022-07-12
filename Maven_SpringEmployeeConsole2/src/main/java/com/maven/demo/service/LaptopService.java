package com.maven.demo.service;

import java.util.List;

import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.DatabaseTableEmptyException;
import com.maven.demo.exception.LaptopStillLoanedOutException;
import com.maven.demo.model.Laptop;

public interface LaptopService {

	public Laptop addLaptop(Laptop laptop);

	public List<Laptop> getAllLaptops() throws DatabaseTableEmptyException;

	public Laptop getLaptopById(int laptopId);
	
	public List<Laptop> getLaptopByAvailabilityStatus(boolean status);
	
	public boolean updateLaptopAvailability(int laptopId, boolean isAvailable) throws DBDataNotModifiedException;

	public boolean deleteLaptop(int laptopId) throws DBDataNotModifiedException, LaptopStillLoanedOutException;

}