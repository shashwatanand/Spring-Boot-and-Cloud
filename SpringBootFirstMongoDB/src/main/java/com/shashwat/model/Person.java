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
	
	public Person(PersonBuilder builder) {
		this.firstName = builder.getFirstName();
        this.lastName = builder.getLastName();
	}
	
	public String getId() {
        return id;
    }
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public static PersonBuilder getBuilder() {
        return new PersonBuilder();
    }
	
	public void update(String firstName, String lastName) {
		verifyFirstAndLastName(firstName, lastName);
		this.firstName = firstName;
		this.lastName = lastName;
	}

	void verifyFirstAndLastName(String firstName, String lastName) {
		notNull(firstName, "First Name cannot be null");
        notNull(lastName, "Last Name cannot be null");
        
        notEmpty(firstName, "First Name cannot be empty");
        notEmpty(lastName, "Last Name cannot be empty");
	}
}
