package com.mat37.SafetyNet_Alerts.DTO;

import java.util.List;

import com.mat37.SafetyNet_Alerts.model.Person;

import lombok.Data;

@Data
public class ChildAlertDTO {

	private final List<Person> childList;
	private final List<Person> houseMembers;

}
