package com.mat37.SafetyNet.Alerts.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mat37.SafetyNet.Alerts.model.Person;
import com.mat37.SafetyNet.Alerts.repository.PersonRepository;

import lombok.Data;

@Data
@Service
public class PersonService {

	private PersonRepository personRepository;

	public Optional<Person> getPerson(final Long id) {
		return personRepository.findById(id);
	}

	public Iterable<Person> getPersons() {
		return personRepository.findAll();
	}

	public void deletePerson(final Long id) {
		personRepository.deleteById(id);
	}

	public Person SavePerson(Person person) {
		Person savePerson = personRepository.save(person);
		return savePerson;
	}
}
