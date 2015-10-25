package com.shashwat.service;

import java.util.List;

import com.shashwat.model.PersonDTO;

public interface PersonService {
	PersonDTO create(PersonDTO personDTO);
	PersonDTO delete(String id);
	List<PersonDTO> findAll();
	PersonDTO update(PersonDTO personDTO);
	PersonDTO searchById(String id);
}
