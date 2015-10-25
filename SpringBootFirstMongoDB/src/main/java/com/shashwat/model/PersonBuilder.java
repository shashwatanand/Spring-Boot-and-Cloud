package com.shashwat.model;

public class PersonBuilder {
	private String firstName;
	
	private String lastName;
	
	public PersonBuilder() {}

	public PersonBuilder updateFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public PersonBuilder updateLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public Person build() {
		Person person = new Person(this);
		person.verifyFirstAndLastName(person.getFirstName(), person.getLastName());
		return person;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
