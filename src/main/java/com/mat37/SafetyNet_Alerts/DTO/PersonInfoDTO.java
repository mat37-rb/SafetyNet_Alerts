package com.mat37.SafetyNet_Alerts.DTO;

import java.util.List;

import lombok.Data;

@Data
public class PersonInfoDTO {

	private final String firstName;
	private final String address;
	private final Long age;
	private final String email;
	private final List<String> medications;
	private final List<String> allergies;

}
