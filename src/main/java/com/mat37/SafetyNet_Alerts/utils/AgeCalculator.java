package com.mat37.SafetyNet_Alerts.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.mat37.SafetyNet_Alerts.model.Medicalrecord;

public class AgeCalculator {

	private AgeCalculator() {
	}

	private static final long CHILD_UNDERAGE = 18;

	public static Long ageCalculation(LocalDate birthdate) {

		LocalDateTime personsBirthdate = LocalDateTime.of(birthdate, null);
		LocalDate currentDate = LocalDate.now();
		long age = ChronoUnit.YEARS.between(personsBirthdate, currentDate);
		return age;
	}

	public static boolean isChild(Medicalrecord medicalrecord) {

		boolean isChild = false;
		Long personAge = ageCalculation(medicalrecord.getBirthdate());
		if (personAge < CHILD_UNDERAGE) {
			isChild = true;
		}
		return isChild;
	}

}
