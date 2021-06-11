package com.mat37.SafetyNet_Alerts.DTO;

import lombok.Data;

@Data
public class ChildAlertDTO {

	private String firstName;
	private String lastName;
	private int age;

	public ChildAlertDTO(String childFirstName, String childLastName, int childAge) {

		this.firstName = childFirstName;
		this.lastName = childLastName;
		this.age = childAge;
	}

}
