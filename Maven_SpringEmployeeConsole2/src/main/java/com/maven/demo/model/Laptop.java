package com.maven.demo.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity				
public class Laptop implements Serializable, Comparable<Laptop>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int laptopId;
	
	@NotEmpty(message = "Laptop model required")
	private String model;
	
	@PastOrPresent(message = "Date must be today or a date in the past")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfPurchased;
	
	private boolean isAvailable = true;

	
	public Laptop() {
		super();
	}

	
	//	Without boolean isAvailable, as default is set to true
	public Laptop(int laptopId, @NotEmpty(message = "Laptop model required") String model,
			@PastOrPresent(message = "Date must be today or a date in the past") LocalDate dateOfPurchased) {
		super();
		this.laptopId = laptopId;
		this.model = model;
		this.dateOfPurchased = dateOfPurchased;
	}
	
	
	//	All fields
	public Laptop(int laptopId, @NotEmpty(message = "Laptop model required") String model,
			@PastOrPresent(message = "Date must be today or a date in the past") LocalDate dateOfPurchased,
			boolean isAvailable) {
		super();
		this.laptopId = laptopId;
		this.model = model;
		this.dateOfPurchased = dateOfPurchased;
		this.isAvailable = isAvailable;
	}

	
	public int getLaptopId() {
		return laptopId;
	}


	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public LocalDate getDateOfPurchased() {
		return dateOfPurchased;
	}


	public void setDateOfPurchased(LocalDate dateOfPurchased) {
		this.dateOfPurchased = dateOfPurchased;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	
	@Override
	public String toString() {
		return "Laptop [laptopId=" + laptopId + ", model=" + model + ", dateOfPurchased=" + dateOfPurchased + "]";
	}

	
	@Override
	public int compareTo(Laptop laptop2) {
		return this.getLaptopId( )- laptop2.getLaptopId();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateOfPurchased == null) ? 0 : dateOfPurchased.hashCode());
		result = prime * result + (isAvailable ? 1231 : 1237);
		result = prime * result + laptopId;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		if (dateOfPurchased == null) {
			if (other.dateOfPurchased != null)
				return false;
		} else if (!dateOfPurchased.equals(other.dateOfPurchased))
			return false;
		if (isAvailable != other.isAvailable)
			return false;
		if (laptopId != other.laptopId)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}
	
}