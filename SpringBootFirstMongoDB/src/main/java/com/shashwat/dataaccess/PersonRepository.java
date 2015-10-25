package com.shashwat.dataaccess;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.Repository;

import com.shashwat.model.Person;

public interface PersonRepository extends Repository<Person, String> {
	void delete(Person person);
	List<Person> findAll();
	Optional<Person> findOne(String id);
	Person save(Person person);
}
