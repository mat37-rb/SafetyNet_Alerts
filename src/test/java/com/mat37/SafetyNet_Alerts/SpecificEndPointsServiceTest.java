package com.mat37.SafetyNet_Alerts;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.mat37.SafetyNet_Alerts.service.PersonService;
import com.mat37.SafetyNet_Alerts.service.SpecificEndPointsService;

@WebMvcTest(PersonService.class)
@ExtendWith(MockitoExtension.class)
public class SpecificEndPointsServiceTest {

	@InjectMocks
	private PersonService personService;
	private SpecificEndPointsService specificEndPointsService;

	@Mock
	private static Person personMock1;
	private static Person personMock2;

	@BeforeEach
	private void setUpPerTest() {
	}

	@Test
	@Tag("CommunityEmail")
	@DisplayName("Search For Existing Person")
	public void personExisting() {
		// GIVEN
		List<Person> personsList = new ArrayList<>();
		personMock1 = new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512",
				"jaboyd@email.com");
		personMock2 = new Person("Jacob", "Boyd", "1509 Culver St", "PARIS", "97451", "841-874-6513", "drk@email.com");
		personsList.add(personMock1);
		personsList.add(personMock2);
		when(personService.savePerson(personMock1)).thenReturn(personMock1);
		when(personService.savePerson(personMock2)).thenReturn(personMock2);
		// WHEN
		List<String> actualResult = specificEndPointsService.communityEmail("Culver");
		// THEN
		assertThat(((List<String>) actualResult).size()).isEqualTo(1);
	}

}
