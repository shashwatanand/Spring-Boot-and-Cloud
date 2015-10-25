package com.shashwat.model;

import org.springframework.data.annotation.Id;

final class Person {
	@Id
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	public Person() {}
	
	private Person(Builder builder) {
		
	}
	
	private static class Builder{
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
			person.updateFirstAndLastName(person.getFirstName(), person.getLastName());
			return person;
		}
	}
}
