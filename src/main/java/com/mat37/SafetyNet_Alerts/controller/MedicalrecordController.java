package com.mat37.SafetyNet_Alerts.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mat37.SafetyNet_Alerts.model.Medicalrecord;
import com.mat37.SafetyNet_Alerts.service.MedicalrecordService;

import lombok.Data;

@Data
@RestController
public class MedicalrecordController {

	private static final Logger logger = LogManager.getLogger(MedicalrecordController.class);

	@Autowired
	MedicalrecordService medicalrecordService;

	@PostMapping("/medicalrecord")
	public Medicalrecord addMedicalrecord(Medicalrecord medicalrecord) {
		Medicalrecord medicalrecordAdded = medicalrecordService.saveMedicalrecord(medicalrecord);
		if (medicalrecordAdded == null) {
			logger.error("Le dossier médical n'a pas été créée");
		}
		return medicalrecordAdded;
	}

	@PutMapping("/medicalrecord")
	public Medicalrecord updateMedicalrecord(@RequestBody Medicalrecord medicalrecord) {
		String id = Medicalrecord.generateId(medicalrecord);
		Optional<Medicalrecord> m = medicalrecordService.getMedicalrecord(id);
		if (m.isPresent()) {
			Medicalrecord currentMedicalrecord = m.get();

			String firstName = medicalrecord.getFirstName();
			if (firstName != null) {
				currentMedicalrecord.setFirstName(firstName);
			}
			String lastName = medicalrecord.getLastName();
			if (lastName != null) {
				currentMedicalrecord.setLastName(lastName);
				;
			}
			LocalDate birthdate = medicalrecord.getBirthdate();
			if (birthdate != null) {
				currentMedicalrecord.setBirthdate(birthdate);
			}
			List<String> medications = medicalrecord.getMedications();
			if (medications != null) {
				currentMedicalrecord.setMedications(medications);
				;
			}
			List<String> allergies = medicalrecord.getAllergies();
			if (allergies != null) {
				currentMedicalrecord.setAllergies(allergies);
				;
			}
			medicalrecordService.saveMedicalrecord(currentMedicalrecord);
			return currentMedicalrecord;
		} else {
			return null;
		}
	}

	@DeleteMapping("/person")
	public void deleteMedicalrecord(@RequestBody final Medicalrecord medicalrecord) {
		medicalrecordService.deleteMedicalrecord(Medicalrecord.generateId(medicalrecord));
	}

}
