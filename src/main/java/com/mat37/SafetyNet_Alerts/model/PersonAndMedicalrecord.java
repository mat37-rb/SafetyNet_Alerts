package com.mat37.SafetyNet_Alerts.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonAndMedicalrecord {

	private List<Person> PersonList;
	private Map<String, Firestation> firestations;

}
