package com.maven.demo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Address implements Serializable { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String blockNumber;
	
	private String streetName;
	
	private String unitNumber;
	
	private long postalCode;
	
	private String country;
	
	
	public Address() {
		super();
	}

	
	public Address(String blockNumber, String streetName, String unitNumber, long postalCode, String country) {
		super();
		this.blockNumber = blockNumber;
		this.streetName = streetName;
		this.unitNumber = unitNumber;
		this.postalCode = postalCode;
		this.country = country;
	}

	
	public String getBlockNumber() {
		return blockNumber;
	}

	
	public void setBlockNumber(String blockNumber) {
		this.blockNumber = blockNumber;
	}

	
	public String getStreetName() {
		return streetName;
	}

	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	
	public String getUnitNumber() {
		return unitNumber;
	}

	
	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	
	public long getPostalCode() {
		return postalCode;
	}

	
	public void setPostalCode(long postalCode) {
		this.postalCode = postalCode;
	}

	
	public String getCountry() {
		return country;
	}

	
	public void setCountry(String country) {
		this.country = country;
	}

	
	@Override
	public String toString() {
		return "Address [blockNumber=" + blockNumber + ", streetName=" + streetName + ", unitNumber=" + unitNumber
				+ ", postalCode=" + postalCode + ", country=" + country + "]";
	}

}