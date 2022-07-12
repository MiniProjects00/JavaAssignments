package com.maven.demo.web;

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

import com.maven.demo.exception.DBDataNotModifiedException;
import com.maven.demo.exception.DatabaseTableEmptyException;
import com.maven.demo.exception.LaptopStillLoanedOutException;
import com.maven.demo.model.Laptop;
import com.maven.demo.service.LaptopService;

@Component																	
@Validated
@RestController
@RequestMapping("employeeConsole/hr")
public class LaptopRestController {
	

	@Autowired 
	LaptopService laptopService;
	
	
	//.......................................... addLaptop ..........................................

	
	@PostMapping("/laptop/add")
	public ResponseEntity<Laptop> addLaptop(@RequestBody @Valid Laptop laptop)	{
		
		Laptop savedLaptop = laptopService.addLaptop(laptop);
		
		return new ResponseEntity<Laptop>(savedLaptop, HttpStatus.OK);
	}
	
	
	//........................................ getAllLaptops ........................................

	
	@GetMapping("/laptop/getAllLaptops")
	public ResponseEntity<List<Laptop>> getAllLaptops() throws DatabaseTableEmptyException {
		
		List<Laptop> listOfLaptops = laptopService.getAllLaptops();
		
		return new ResponseEntity<List<Laptop>>(listOfLaptops, HttpStatus.OK);
	}
	
	
	//........................................ getLaptopById ........................................

	
	@GetMapping("/laptop/{laptopId}")
	public ResponseEntity<Laptop> getLaptopById(@PathVariable int laptopId) {
		
		Laptop laptopRetrieved = laptopService.getLaptopById(laptopId);
		
		return new ResponseEntity<Laptop>(laptopRetrieved, HttpStatus.OK);
	}
	
	
	//................................ getLaptopByAvailabilityStatus ................................

	
	@GetMapping("/laptop/getAllLaptopsByAvailability")
	public ResponseEntity<List<Laptop>> getLaptopByAvailabilityStatus(@RequestParam boolean laptopAvailable) {

		List<Laptop> listOfLaptops = laptopService.getLaptopByAvailabilityStatus(laptopAvailable);

		return new ResponseEntity<List<Laptop>>(listOfLaptops, HttpStatus.OK);
	}
		
		
	//................................... updateLaptopAvailability ..................................

	
	@PutMapping("laptop/{laptopId}/edit/isAvailable")
	public boolean updateLaptopAvailability(@PathVariable int laptopId, @RequestParam boolean isAvailable) throws DBDataNotModifiedException  {
		
		boolean isUpdated = laptopService.updateLaptopAvailability(laptopId, isAvailable);
		
		return isUpdated;
	}

	
	//......................................... deleteLaptop.........................................
		
	
	@DeleteMapping("/laptop/delete")
	public boolean deleteLaptop(@RequestParam int laptopId) throws DBDataNotModifiedException, LaptopStillLoanedOutException {
			
			return laptopService.deleteLaptop(laptopId);
	}

}