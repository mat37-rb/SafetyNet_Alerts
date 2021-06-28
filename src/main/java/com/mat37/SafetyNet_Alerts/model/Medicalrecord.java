package com.mat37.SafetyNet_Alerts.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mat37.SafetyNet_Alerts.utils.AgeCalculator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medicalrecords")
public class Medicalrecord {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	private String medications;
	private String allergies;

	public static String generateId(Medicalrecord medicalrecord) {
		return medicalrecord.getFirstName() + "_" + medicalrecord.getLastName();
	}

	public Long getAge() {
		return AgeCalculator.ageCalculation(birthdate);
	}
}
