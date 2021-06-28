package com.mat37.SafetyNet_Alerts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mat37.SafetyNet_Alerts.DTO.ChildAlertDTO;
import com.mat37.SafetyNet_Alerts.DTO.FireDTO;
import com.mat37.SafetyNet_Alerts.DTO.FirePersonDTO;
import com.mat37.SafetyNet_Alerts.DTO.FirestationDTO;
import com.mat37.SafetyNet_Alerts.DTO.FirestationPersonDTO;
import com.mat37.SafetyNet_Alerts.DTO.FloodStationDTO;
import com.mat37.SafetyNet_Alerts.DTO.PersonInfoDTO;
import com.mat37.SafetyNet_Alerts.DTO.PhoneAlertDTO;
import com.mat37.SafetyNet_Alerts.model.Firestation;
import com.mat37.SafetyNet_Alerts.model.Medicalrecord;
import com.mat37.SafetyNet_Alerts.model.Person;
import com.mat37.SafetyNet_Alerts.repository.FirestationRepository;
import com.mat37.SafetyNet_Alerts.repository.MedicalrecordRepository;
import com.mat37.SafetyNet_Alerts.repository.PersonRepository;
import com.mat37.SafetyNet_Alerts.utils.AgeCalculator;

@Service
public class SpecificEndPointsService {

//	private static final Logger logger = LogManager.getLogger(PersonService.class);

	@Autowired
	PersonService personService;
	@Autowired
	FirestationService firestationService;
	@Autowired
	MedicalrecordService medicalrecordService;
	@Autowired
	PersonRepository personRepository;
	@Autowired
	FirestationRepository firestationRepository;
	@Autowired
	MedicalrecordRepository medicalrecordRepository;

	public FirestationDTO firestation(int stationNumber) {
		int totalAdult = 0;
		int totalChild = 0;
		List<String> firestationAddress = new ArrayList<>();
		List<Firestation> firestationListFiltred = firestationRepository.findByStationNumber(stationNumber);
		for (Firestation firestation : firestationListFiltred) {
			firestationAddress.add(firestation.getAddress());
		}
		List<FirestationPersonDTO> firestationPersonDTOList = new ArrayList<>();
		List<Person> personListFiltred = personRepository.findByAddressIn(firestationAddress);
		for (Person person : personListFiltred) {
			FirestationPersonDTO firestationPersonDTO = new FirestationPersonDTO(person.getFirstName(),
					person.getLastName(), person.getAddress(), person.getPhone());
			firestationPersonDTOList.add(firestationPersonDTO);
		}

		for (Person person : personListFiltred) {
			List<Medicalrecord> medicalRecordList = medicalrecordRepository
					.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
			if (medicalRecordList.isEmpty()) {
				continue;
			} else {
				if (AgeCalculator.isChild(medicalRecordList.get(0))) {
					totalChild++;
				} else {
					totalAdult++;
				}
			}
		}
		return new FirestationDTO(firestationPersonDTOList, totalAdult, totalChild);
	}

	public ChildAlertDTO childAlert(String address) {
		List<Person> childList = new ArrayList<Person>();
		List<Person> houseMembers = new ArrayList<Person>();
		List<Person> personListFiltred = personRepository.findByAddress(address);
		for (Person person : personListFiltred) {
			List<Medicalrecord> medicalRecordList = medicalrecordRepository
					.findByFirstNameAndLastName(person.getFirstName(), person.getLastName());
			if (medicalRecordList.isEmpty()) {
				continue;
			} else {
				if (AgeCalculator.isChild(medicalRecordList.get(0))) {
					childList.add(person);
				} else {
					houseMembers.add(person);
				}
			}
		}
		return new ChildAlertDTO(childList, houseMembers);
	}

	public List<PhoneAlertDTO> phoneAlert(int stationNumber) {
		List<String> firestationAddress = new ArrayList<>();
		List<Firestation> firestationListFiltred = firestationRepository.findByStationNumber(stationNumber);
		for (Firestation firestation : firestationListFiltred) {
			firestationAddress.add(firestation.getAddress());
		}
		List<PhoneAlertDTO> phoneAlertDTOList = new ArrayList<>();
		List<Person> personListFiltred = personRepository.findByAddressIn(firestationAddress);
		for (Person person : personListFiltred) {
			PhoneAlertDTO firestationPersonDTO = new PhoneAlertDTO(person.getPhone());
			phoneAlertDTOList.add(firestationPersonDTO);
		}
		return phoneAlertDTOList;
	}

	public FireDTO fire(final String address) {
		List<FirePersonDTO> listFirePersonDTO = new ArrayList<>();
		List<String> listPersonByAddress = new ArrayList<>();
		List<Person> personListFiltred = personRepository.findByAddress(address);
		for (Person person : personListFiltred) {
			listPersonByAddress.add(person.getAddress());
		}
		List<Integer> firestationNumber = new ArrayList<>();
		List<Firestation> listFirestationByAddress = firestationRepository.findByAddressIn(listPersonByAddress);
		for (Firestation firestation : listFirestationByAddress) {
			firestationNumber.add(firestation.getStationNumber());
		}
		List<String> listPersonByLastName = new ArrayList<>();
		for (Person person : personListFiltred) {
			listPersonByLastName.add(person.getLastName());
			List<Medicalrecord> medicalRecordList = medicalrecordRepository.findByLastNameIn(listPersonByLastName);
			Medicalrecord medicalrecord = medicalRecordList.stream()
					.filter(m -> m.getFirstName().equals(person.getFirstName())).findFirst()
					.orElse(new Medicalrecord());
			FirePersonDTO firePersonDTO = new FirePersonDTO(person.getLastName(), person.getPhone(),
					medicalrecord.getAge(), medicalrecord.getMedications().split(";"),
					medicalrecord.getAllergies().split(";"));
			listFirePersonDTO.add(firePersonDTO);
		}
		return new FireDTO(listFirePersonDTO, firestationNumber);
	}

	public List<FloodStationDTO> floodStation(List<Integer> stationNumber) {
		List<FloodStationDTO> listFloodStationDTO = new ArrayList<>();
		List<String> firestationAddress = new ArrayList<>();
		List<Firestation> firestationListFiltred = firestationRepository.findByStationNumberIn(stationNumber);
		for (Firestation firestation : firestationListFiltred) {
			firestationAddress.add(firestation.getAddress());
		}
		List<String> listPersonFiltredByAddress = new ArrayList<>();
		List<Person> ListPersonByAddress = personRepository.findByAddressIn(firestationAddress);
		for (Person person : ListPersonByAddress) {
			listPersonFiltredByAddress.add(person.getLastName());
			List<Medicalrecord> medicalRecordList = medicalrecordRepository
					.findByLastNameIn(listPersonFiltredByAddress);
			Medicalrecord medicalrecord = medicalRecordList.stream()
					.filter(m -> m.getFirstName().equals(person.getFirstName())).findFirst()
					.orElse(new Medicalrecord());
			FloodStationDTO floodStationDTO = new FloodStationDTO(person.getLastName(), person.getFirstName(),
					person.getPhone(), medicalrecord.getAge(), medicalrecord.getMedications().split(";"),
					medicalrecord.getAllergies().split(";"));
			listFloodStationDTO.add(floodStationDTO);
		}
		return listFloodStationDTO;
	}

	public List<PersonInfoDTO> personInfo(String firstName, String lastName) {
		List<PersonInfoDTO> personInfoList = new ArrayList<>();
		List<Person> personListFiltred = personRepository.findByLastName(lastName);
		List<Medicalrecord> medicalRecordList = medicalrecordRepository.findByLastName(lastName);
		for (Person person : personListFiltred) {
			Medicalrecord medicalrecord = medicalRecordList.stream()
					.filter(m -> m.getFirstName().equals(person.getFirstName())).findFirst()
					.orElse(new Medicalrecord());
			PersonInfoDTO personInfos = new PersonInfoDTO(person.getFirstName(), person.getAddress(),
					medicalrecord.getAge(), person.getEmail(), medicalrecord.getMedications().split(";"),
					medicalrecord.getAllergies().split(";"));
			personInfoList.add(personInfos);
		}
		return personInfoList;
	}

	public List<String> communityEmail(final String city) {
		List<String> communityEmail = new ArrayList<>();
		List<Person> personListFiltred = personRepository.findByCity(city);
		for (Person person : personListFiltred) {
			communityEmail.add(person.getEmail());
		}
		return communityEmail;
	}

}
