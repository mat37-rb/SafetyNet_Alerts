package com.mat37.SafetyNet_Alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mat37.SafetyNet_Alerts.DTO.ChildAlertDTO;
import com.mat37.SafetyNet_Alerts.DTO.FireDTO;
import com.mat37.SafetyNet_Alerts.DTO.FirestationDTO;
import com.mat37.SafetyNet_Alerts.DTO.PersonInfoDTO;
import com.mat37.SafetyNet_Alerts.DTO.PhoneAlertDTO;
import com.mat37.SafetyNet_Alerts.model.Medicalrecord;
import com.mat37.SafetyNet_Alerts.model.Person;
import com.mat37.SafetyNet_Alerts.repository.MedicalrecordRepository;
import com.mat37.SafetyNet_Alerts.repository.PersonRepository;

@Service
public class SpecificEndPointsService {

	private static final Logger logger = LogManager.getLogger(PersonService.class);

	@Autowired
	PersonService personService;
	@Autowired
	FirestationService firestationService;
	@Autowired
	MedicalrecordService medicalrecordService;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	MedicalrecordRepository medicalrecordRepository;

	public List<FirestationDTO> firestation(int stationNumber) {
		List<FirestationDTO> firestation = new ArrayList<>();
		return firestation(stationNumber);
	}

	public List<ChildAlertDTO> childAlert(final String address) {
		List<ChildAlertDTO> childAlert = new ArrayList<>();
		return childAlert;
	}

	public List<PhoneAlertDTO> phoneAlert(final int firestationNumber) {
		List<PhoneAlertDTO> phoneAlert = new ArrayList<>();
		return phoneAlert;
	}

	public List<FireDTO> fire(final String address) {
		List<FireDTO> fire = new ArrayList<>();
		return fire;
	}

	public List<PersonInfoDTO> personInfo(String firstName, String lastName) {
		List<PersonInfoDTO> personInfoList = new ArrayList<>();
		List<Person> personList = personRepository.findByLastName(lastName);
		List<Medicalrecord> medicalRecordList = medicalrecordRepository.findByLastName(lastName);
		for (Person person : personList) {
			Medicalrecord medicalrecord = medicalRecordList.stream()
					.filter(m -> m.getFirstName().equals(person.getFirstName())).findFirst()
					.orElse(new Medicalrecord());
			PersonInfoDTO personInfos = new PersonInfoDTO(person.getFirstName(), person.getAddress(),
					medicalrecord.getAge(), person.getEmail(), medicalrecord.getMedications(),
					medicalrecord.getAllergies());
			personInfoList.add(personInfos);
		}
		return personInfoList;
	}

	public List<String> communityEmail(final String city) {
		List<String> communityEmail = new ArrayList<>();
		Iterable<Person> personList = personRepository.findByCity(city);
		for (Person person : personList) {
			communityEmail.add(person.getEmail());
		}
		return communityEmail;
	}

}
