package com.mat37.SafetyNet_Alerts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mat37.SafetyNet_Alerts.model.Person;
import com.mat37.SafetyNet_Alerts.repository.PersonRepository;

import lombok.Data;

@Data
@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Optional<Person> getPerson(final String id) {
		return personRepository.findById(id);
	}

	public Iterable<Person> getPersons() {
		return personRepository.findAll();
	}

	public void deletePerson(final String id) {
		personRepository.deleteById(id);
	}

	public void deletePersons() {
		personRepository.deleteAll();
	}

	public Person savePerson(Person person) {
		Person savePerson = personRepository.save(person);
		return savePerson;
	}

}
