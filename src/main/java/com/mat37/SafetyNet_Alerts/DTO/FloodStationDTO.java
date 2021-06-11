package com.mat37.SafetyNet_Alerts.DTO;

import java.util.List;

import lombok.Data;

@Data
public class FloodStationDTO {

	// Liste des foyers desservis par la caserne
	// Regrouper les personnes par adresse
	private final String firstName;
	private final String phone;
	private final int age;
	private final List<String> medications;
	private final List<String> allergies;

}
