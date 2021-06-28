package com.mat37.SafetyNet_Alerts.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mat37.SafetyNet_Alerts.model.Firestation;
import com.mat37.SafetyNet_Alerts.service.FirestationService;

@RestController
public class FirestationController {

	private static final Logger logger = LogManager.getLogger(FirestationController.class);

	@Autowired
	FirestationService firestationService;

	@PostMapping("/firestation")
	public Firestation addFirestation(Firestation firestation) {
		Firestation firestationAdded = firestationService.saveFirestation(firestation);
		if (firestationAdded == null) {
			logger.error("La caserne n'a pas été créée");
		}
		return firestationAdded;
	}

	@PutMapping("/firestation")
	public Firestation updateFirestation(@RequestBody Firestation firestation) {
		String id = Firestation.generateId(firestation);
		Optional<Firestation> f = firestationService.getFirestation(id);
		if (f.isPresent()) {
			Firestation currentFirestation = f.get();

			String address = firestation.getAddress();
			if (address != null) {
				currentFirestation.setAddress(address);
			}
			int station = firestation.getStationNumber();
			if (station != 0) {
				currentFirestation.setStationNumber(station);
				;
			}
			firestationService.saveFirestation(currentFirestation);
			return currentFirestation;
		} else {
			logger.error("La caserne n'a pas été mis à jour");
			return null;
		}
	}

	@DeleteMapping("/firestation")
	public void deleteFirestation(@RequestBody final Firestation firestation) {
		firestationService.deleteFirestation(Firestation.generateId(firestation));
	}

}
