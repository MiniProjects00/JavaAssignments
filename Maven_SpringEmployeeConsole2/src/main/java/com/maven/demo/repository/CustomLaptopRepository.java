package com.maven.demo.repository;

import java.util.List;

import com.maven.demo.model.Laptop;

public interface CustomLaptopRepository {

	public List<Laptop> getLaptopByAvailabilityStatus(boolean laptopAvailable);

}