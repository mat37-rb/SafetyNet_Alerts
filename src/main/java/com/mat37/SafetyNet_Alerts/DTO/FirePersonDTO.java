package com.mat37.SafetyNet_Alerts.DTO;

import lombok.Data;

@Data
public class FirePersonDTO {

	private final String lastName;
	private final String phone;
	private final Long age;
	private final String[] medications;
	private final String[] allergies;

}
