package com.mat37.SafetyNet_Alerts.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mat37.SafetyNet_Alerts.model.Medicalrecord;
import com.mat37.SafetyNet_Alerts.repository.MedicalrecordRepository;

import lombok.Data;

@Data
@Service
public class MedicalrecordService {

	@Autowired
	private MedicalrecordRepository medicalrecordRepository;

	public Optional<Medicalrecord> getMedicalrecord(final String id) {
		return medicalrecordRepository.findById(id);
	}

	public Iterable<Medicalrecord> getMedicalrecords() {
		return medicalrecordRepository.findAll();
	}

	public void deleteMedicalrecord(final String id) {
		medicalrecordRepository.deleteById(id);
	}

	public Medicalrecord saveMedicalrecord(Medicalrecord medicalrecord) {
		Medicalrecord saveMedicalrecord = medicalrecordRepository.save(medicalrecord);
		return saveMedicalrecord;
	}
}
