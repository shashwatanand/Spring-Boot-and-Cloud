package com.shashwat;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shashwat.model.PersonDTO;
import com.shashwat.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	private PersonService service;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.service = personService;
	}
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	PersonDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return this.service.create(personDTO);
    }
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	PersonDTO delete(@PathVariable("id") String id) {
		return this.service.delete(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	List<PersonDTO> findAll() {
		return this.service.findAll();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	PersonDTO searchById(@PathVariable("id") String id) {
		return this.service.searchById(id);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	PersonDTO update(@RequestBody @Valid PersonDTO personDTO) {
		return this.update(personDTO);
	}
}
