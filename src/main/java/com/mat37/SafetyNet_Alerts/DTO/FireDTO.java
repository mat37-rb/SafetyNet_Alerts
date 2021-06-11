package com.mat37.SafetyNet_Alerts.DTO;

import java.util.List;

import lombok.Data;

@Data
public class FireDTO {

	private final String stationNumber;
	private final String firstName;
	private final String phone;
	private final int age;
	private final List<String> medications;
	private final List<String> allergies;

}
