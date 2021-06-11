package com.mat37.SafetyNet_Alerts.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mat37.SafetyNet_Alerts.utils.AgeCalculator;

import lombok.Data;

@Data
@Entity
@Table(name = "medicalrecords")
public class Medicalrecord {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	private Long age = AgeCalculator.ageCalculation(birthdate);
	private List<String> medications;
	private List<String> allergies;

	public static String generateId(Medicalrecord medicalrecord) {
		return medicalrecord.getFirstName() + "_" + medicalrecord.getLastName();
	}
}
