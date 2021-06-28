package com.mat37.SafetyNet_Alerts.DTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.mat37.SafetyNet_Alerts.model.Medicalrecord;

import lombok.Data;

@Data
public class MedicalrecordDTO {

	private String firstName;
	private String lastName;
	private String birthdate;
	private String[] medications;
	private String[] allergies;
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");

	public Medicalrecord toMedicalrecord() {
		return new Medicalrecord(firstName, lastName, LocalDate.parse(birthdate, formatter),
				String.join(";", medications), String.join(";", allergies));
	}
}
