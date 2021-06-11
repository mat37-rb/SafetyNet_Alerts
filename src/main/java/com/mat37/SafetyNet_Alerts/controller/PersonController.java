package com.mat37.SafetyNet_Alerts.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mat37.SafetyNet_Alerts.model.Person;
import com.mat37.SafetyNet_Alerts.service.PersonService;

@RestController
//@RequestMapping("/person")
public class PersonController {

	private static final Logger logger = LogManager.getLogger(PersonController.class);

	@Autowired
	PersonService personService;

	/**
	 * Read - Get one person
	 * 
	 * @param id The id of the person
	 * @return An Person object full filled
	 */
//	@GetMapping("/person/{id}")
//	public Person getPerson(@PathVariable("id") final Long id) {
//		Optional<Person> person = personService.getPerson(id);
//		if (person.isPresent()) {
//			return person.get();
//		} else {
//			return null;
//		}
//	}

//	@GetMapping("/")
//	public String home() {
//		return "home";
//	}

	@PostMapping("/person")
	public Person addPerson(Person person) {
		Person personAdded = personService.savePerson(person);
		if (personAdded == null) {
			logger.error("La personne n'a pas été créée");
		}
		return personAdded;
	}

	@PutMapping("/person")
	public Person updatePerson(@RequestBody Person person) {
		String id = Person.generateId(person);
		Optional<Person> p = personService.getPerson(id);
		if (p.isPresent()) {
			Person currentPerson = p.get();

			String firstName = person.getFirstName();
			if (firstName != null) {
				currentPerson.setFirstName(firstName);
			}
			String lastName = person.getLastName();
			if (lastName != null) {
				currentPerson.setLastName(lastName);
				;
			}
			String address = person.getAddress();
			if (address != null) {
				currentPerson.setAddress(address);
			}
			String city = person.getCity();
			if (city != null) {
				currentPerson.setCity(city);
				;
			}
			String zip = person.getZip();
			if (zip != null) {
				currentPerson.setZip(zip);
				;
			}
			String phone = person.getPhone();
			if (phone != null) {
				currentPerson.setPhone(phone);
				;
			}
			String email = person.getEmail();
			if (email != null) {
				currentPerson.setEmail(email);
				;
			}
			personService.savePerson(currentPerson);
			return currentPerson;
		} else {
			logger.error("Le profil de la personne n'a pas été mis à jour");
			return null;
		}
	}

	@DeleteMapping("/person")
	public void deletePerson(@RequestBody final Person person) {
		personService.deletePerson(Person.generateId(person));
	}

}
