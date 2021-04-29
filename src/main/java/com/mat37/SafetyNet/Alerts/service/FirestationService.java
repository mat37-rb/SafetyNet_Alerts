package com.mat37.SafetyNet.Alerts.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mat37.SafetyNet.Alerts.model.Firestation;
import com.mat37.SafetyNet.Alerts.repository.FirestationRepository;

import lombok.Data;

@Data
@Service
public class FirestationService {

	private FirestationRepository firestationRepository;

	public Optional<Firestation> getFirestation(final Long id) {
		return firestationRepository.findById(id);
	}

	public Iterable<Firestation> getFirestations() {
		return firestationRepository.findAll();
	}

	public void deleteFirestation(final Long id) {
		firestationRepository.deleteById(id);
	}

	public Firestation SaveFirestation(Firestation firestation) {
		Firestation saveFirestation = firestationRepository.save(firestation);
		return saveFirestation;
	}
}
