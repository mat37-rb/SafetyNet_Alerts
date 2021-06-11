package com.mat37.SafetyNet_Alerts.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class Person {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private long id;
	private String id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;

	public static String generateId(Person person) {
		return person.getFirstName() + "_" + person.getLastName();
	}

	// Constructeur Object Person
	public Person(final String personsFirstName, final String personsLastName, final String personsAddress,
			final String personsCity, final String personsZip, final String personsPhone, final String personsEmail) {
	}

}
