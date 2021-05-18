package com.mat37.SafetyNet.Alerts.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mat37.SafetyNet.Alerts.model.Person;
import com.mat37.SafetyNet.Alerts.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;

	/**
	 * Read - Get one person
	 * 
	 * @param id The id of the person
	 * @return An Person object full filled
	 */
	@GetMapping("/person/{id}")
	public Person getPerson(@PathVariable("id") final Long id) {
		Optional<Person> person = personService.getPerson(id);
		if (person.isPresent()) {
			return person.get();
		} else {
			return null;
		}
	}

	/**
	 * Read - Get all persons
	 * 
	 * @return - An Iterable object of Person full filled
	 */
	@GetMapping("/persons")
	public Iterable<Person> getPersons() {
		return personService.getPersons();
	}

}
