package com.maven.demo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Dependent implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	private String relationship;
	
	
	public Dependent() {}
	
	
	public Dependent(String name, String relationship) {
		super();
		this.name = name;
		this.relationship = relationship;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRelationship() {
		return relationship;
	}


	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	
	@Override
	public String toString() {
		return "Dependent [name=" + name + ", relationship=" + relationship + "]";
	}
	
}