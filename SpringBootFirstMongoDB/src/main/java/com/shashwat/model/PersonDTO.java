package com.shashwat.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PersonDTO {
	private String id;
	
	@NotNull
	@NotEmpty
	private String fistName;
	
	@NotNull
	@NotEmpty
	private String lastName;
	
	public PersonDTO() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFistName() {
		return fistName;
	}

	public void setFistName(String fistName) {
		this.fistName = fistName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("PersonDTO[id=%s, firstName=%s, lastName=%s]",
				this.id, this.fistName, this.lastName);
	}
}
