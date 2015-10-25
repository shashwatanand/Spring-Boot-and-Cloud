package com.shashwat.model;

import org.springframework.data.annotation.Id;

import static com.shashwat.utils.SanityChecks.notEmpty;
import static com.shashwat.utils.SanityChecks.notNull;

final public class Person {
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	public Person() {}
	
	private Person(Builder builder) {
		this.firstName = builder.firstName;
        this.lastName = builder.lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	static Builder getBuilder() {
        return new Builder();
    }
	
	public void update(String firstName, String lastName) {
		verifyFirstAndLastName(firstName, lastName);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	static class Builder{
		private String firstName;
		
		private String lastName;
		
		private Builder() {}

		Builder updateFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		Builder updateLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		Person build() {
			Person person = new Person(this);
			person.verifyFirstAndLastName(person.getFirstName(), person.getLastName());
			return person;
		}
	}

	private void verifyFirstAndLastName(String firstName, String lastName) {
		notNull(firstName, "First Name cannot be null");
        notNull(lastName, "Last Name cannot be null");
        
        notEmpty(firstName, "First Name cannot be empty");
        notEmpty(lastName, "Last Name cannot be empty");
	}
}
