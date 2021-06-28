package com.mat37.SafetyNet_Alerts.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jsoniter.JsonIterator;
import com.mat37.SafetyNet_Alerts.DTO.MedicalrecordDTO;
import com.mat37.SafetyNet_Alerts.model.Firestation;
import com.mat37.SafetyNet_Alerts.model.Medicalrecord;
import com.mat37.SafetyNet_Alerts.model.Person;
import com.mat37.SafetyNet_Alerts.repository.FirestationRepository;
import com.mat37.SafetyNet_Alerts.repository.MedicalrecordRepository;
import com.mat37.SafetyNet_Alerts.repository.PersonRepository;
import com.mat37.SafetyNet_Alerts.utils.JsonData;

@Component
public class JsonToJavaObject implements ApplicationRunner {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private FirestationRepository firestationRepository;
	@Autowired
	private MedicalrecordRepository medicalrecordRepository;

	// Sauvegarder chaque objet
	public void saveFromJson(String filepath) throws IOException {

		JsonData jsonData = retrieveContentsJsonFile(filepath);
		this.savePersons(jsonData.getPersons());
		this.saveFirestations(jsonData.getFirestations());
		this.saveMedicalrecords(jsonData.getMedicalrecords());
	}

	// Récupérer le contenu du fichier Json
	public JsonData retrieveContentsJsonFile(String filepath) throws IOException {

		String content = new String(Files.readAllBytes(Paths.get(filepath)));
		JsonData jsonData = JsonIterator.deserialize(content, JsonData.class);
		return jsonData;
	}

	// Sauvegarder chaque objet comme une liste dans le Repository
	private void savePersons(List<Person> persons) {
		personRepository.saveAll(persons);
	}

	private void saveFirestations(List<Firestation> firestations) {
		firestationRepository.saveAll(firestations);
	}

	private void saveMedicalrecords(List<MedicalrecordDTO> medicalrecordsDTO) {
		List<Medicalrecord> medicalrecords = medicalrecordsDTO.stream().map(MedicalrecordDTO::toMedicalrecord)
				.collect(Collectors.toList());
		medicalrecordRepository.saveAll(medicalrecords);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		saveFromJson("D:\\_MAT\\Formations\\Module 5\\SafetyNet_Alerts\\src\\main\\resources\\Data.json");
	}
}

//		JsonIterator jsonIterator = JsonIterator.parse(content);
//		Any any = jsonIterator.readAny();
//		Any anyPerson = any.get("persons");
//		List<Person> persons = new ArrayList<>();
//		Map<String, List<Person>> PersonList = new HashMap<>();
//		anyPerson.forEach(personJson -> {
//			String firstName = personJson.get("firstName").toString();
//			String lastName = personJson.get("lastName").toString();
//			String address = personJson.get("address").toString();
//			String city = personJson.get("city").toString();
//			String zip = personJson.get("zip").toString();
//			String phone = personJson.get("phone").toString();
//			String email = personJson.get("email").toString();
//
//			Person person = new Person(firstName, lastName, address, city, zip, phone, email);
//		});

//		Any firestation = JsonIterator.deserialize(content);
//		Any medicalRecord = JsonIterator.deserialize(content);
//		return content;

//	public PersonRepository savePersonObject() {
//
//		Any anyPerson = any.get("persons");
//	}