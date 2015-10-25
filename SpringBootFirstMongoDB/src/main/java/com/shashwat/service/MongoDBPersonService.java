package com.shashwat.service;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDTO searchById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Person searchPersonById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
