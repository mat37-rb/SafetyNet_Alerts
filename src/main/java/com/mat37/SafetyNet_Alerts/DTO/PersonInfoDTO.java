package com.mat37.SafetyNet_Alerts.DTO;

import lombok.Data;

@Data
public class PersonInfoDTO {

	private final String firstName;
	private final String address;
	private final Long age;
	private final String email;
	private final String[] medications;
	private final String[] allergies;

}
