package com.mat37.SafetyNet_Alerts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.mat37.SafetyNet_Alerts.model.Person;
import com.mat37.SafetyNet_Alerts.repository.PersonRepository;
import com.mat37.SafetyNet_Alerts.service.PersonService;

@WebMvcTest(PersonService.class)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

	@InjectMocks
	private PersonService personService;
	@InjectMocks
	private PersonRepository personrepository;

	@Mock
	private static Person personMock1;
	@Mock
	private static Person personMock2;

	@BeforeEach
	private void setUpPerTest() {
	}

	@Test
	@Tag("PersonService")
	@DisplayName("Search For Existing Person")
	public void personExisting() {
		// GIVEN
		List<Person> personsList = new ArrayList<>();
		personMock1 = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		personMock2 = new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513", "drk@email.com");
		personsList.add(personMock1);
		personsList.add(personMock2);
		when(personService.savePerson(personMock1)).thenReturn(personMock1);
		when(personService.savePerson(personMock2)).thenReturn(personMock2);
		// WHEN
		Iterable<Person> actualResult = personService.getPersons();
		// THEN
		assertFalse(((List<Person>) actualResult).isEmpty());
		assertThat(((List<Person>) actualResult).size()).isEqualTo(2);
	}

	@Test
	@Tag("PersonService")
	@DisplayName("Search Person By City")
	public void researchPersonByCity() {
		// GIVEN
		List<Person> personsList = new ArrayList<>();
		personMock1 = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		personsList.add(personMock1);
		when(personService.savePerson(personMock1)).thenReturn(personMock1);
		// WHEN
		List<Person> actualResult = personrepository.findByCity("Culver");
		// THEN
		assertFalse(((List<Person>) actualResult).isEmpty());
		assertThat(((List<Person>) actualResult).size()).isEqualTo(1);
	}

//	@Test
//	@Tag("PersonService")
//	@DisplayName("Delete Person")
//	public void deletePerson() {
//		// GIVEN
//		boolean isDelete = true;
//		List<Person> personsList = new ArrayList<>();
//		personMock1 = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
//				"jaboyd@email.com");
//		personsList.add(personMock1);
//		when(personService.savePerson(personMock1)).thenReturn(personMock1);
//		// WHEN
//		actualResult = personService.deletePersons();
//		// THEN
//		assertTrue(((List<Person>) actualResult).isEmpty());
//	}

}
