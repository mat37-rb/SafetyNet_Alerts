package com.mat37.SafetyNet_Alerts.DTO;

import lombok.Data;

@Data
public class FloodStationDTO {

	// Liste des foyers desservis par la caserne
	// Regrouper les personnes par adresse
	private final String lastName;
	private final String firstName;
	private final String phone;
	private final long age;
	private final String[] medications;
	private final String[] allergies;

}
