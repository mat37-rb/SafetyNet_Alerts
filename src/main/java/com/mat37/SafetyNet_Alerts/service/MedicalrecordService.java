package com.mat37.SafetyNet.Alerts.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mat37.SafetyNet.Alerts.model.Medicalrecord;
import com.mat37.SafetyNet.Alerts.repository.MedicalrecordRepository;

import lombok.Data;

@Data
@Service
public class MedicalrecordService {

	private MedicalrecordRepository medicalrecordRepository;

	public Optional<Medicalrecord> getMedicalrecord(final Long id) {
		return medicalrecordRepository.findById(id);
	}

	public Iterable<Medicalrecord> getMedicalrecords() {
		return medicalrecordRepository.findAll();
	}

	public void deleteMedicalrecord(final Long id) {
		medicalrecordRepository.deleteById(id);
	}

	public Medicalrecord SaveMedicalrecord(Medicalrecord medicalrecord) {
		Medicalrecord saveMedicalrecord = medicalrecordRepository.save(medicalrecord);
		return saveMedicalrecord;
	}
}
