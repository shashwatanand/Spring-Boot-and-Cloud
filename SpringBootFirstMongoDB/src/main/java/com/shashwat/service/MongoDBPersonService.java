package com.shashwat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.shashwat.dataaccess.PersonRepository;
import com.shashwat.model.Person;
import com.shashwat.model.PersonDTO;

import static java.util.stream.Collectors.toList;

public class MongoDBPersonService implements PersonService {
	private PersonRepository personRepository;
	
	@Autowired
	public MongoDBPersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	private List<PersonDTO> convertToDTOList(List<Person> list) {
		return list.stream().map(this::convertToDTO)
				.collect(toList());
	}
		
	private PersonDTO convertToDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();
		 
        personDTO.setId(person.getId());
        personDTO.setFirstName(person.getFirstName());
        personDTO.setLastName(person.getLastName());
 
        return personDTO;
	}

	@Override
	public PersonDTO create(PersonDTO personDTO) {
		Person person = Person.getBuilder()
				.updateFirstName(personDTO.getFirstName())
				.updateLastName(personDTO.getLastName())
				.build();
		person = this.personRepository.save(person);
		return convertToDTO(person);
	}

	@Override
	public PersonDTO delete(String id) {
		Person person = searchPersonById(id);
		this.personRepository.delete(person);
		return convertToDTO(person);
	}

	@Override
	public List<PersonDTO> findAll() {
		List<Person> list = this.personRepository.findAll();
		return convertToDTOList(list);
	}

	@Override
	public PersonDTO update(PersonDTO personDTO) {
		Person person = searchPersonById(personDTO.getId());
		person.update(personDTO.getFirstName(), personDTO.getLastName());
		person = this.personRepository.save(person);
		return convertToDTO(person);
	}

	@Override
	public PersonDTO searchById(String id) {
		Person person = searchPersonById(id);
        return convertToDTO(person);
	}
	
	public Person searchPersonById(String id) {
		Optional<Person> personResult = this.personRepository.findOne(id);
		return personResult.orElseThrow(() -> new RuntimeException("Person Not Found"));
	}
}
