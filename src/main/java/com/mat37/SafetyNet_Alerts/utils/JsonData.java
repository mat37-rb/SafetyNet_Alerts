package com.mat37.SafetyNet_Alerts.utils;

import java.util.List;

import com.mat37.SafetyNet_Alerts.DTO.MedicalrecordDTO;
import com.mat37.SafetyNet_Alerts.model.Firestation;
import com.mat37.SafetyNet_Alerts.model.Person;

import lombok.Data;

@Data
public class JsonData {

	private List<Person> persons;
	private List<Firestation> firestations;
	private List<MedicalrecordDTO> medicalrecords;

}
