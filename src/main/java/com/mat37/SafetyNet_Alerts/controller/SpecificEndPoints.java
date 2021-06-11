package com.mat37.SafetyNet_Alerts.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mat37.SafetyNet_Alerts.DTO.ChildAlertDTO;
import com.mat37.SafetyNet_Alerts.DTO.FirestationDTO;
import com.mat37.SafetyNet_Alerts.DTO.PersonInfoDTO;
import com.mat37.SafetyNet_Alerts.service.PersonService;
import com.mat37.SafetyNet_Alerts.service.SpecificEndPointsService;

@RestController
public class SpecificEndPoints {

	@Autowired
	PersonService personService;
	@Autowired
	SpecificEndPointsService specificEndPointsService;

	@GetMapping("/firestation")
	@ResponseBody
	public String getPersonCoveredByStation(@RequestParam(value = "stationNumber") final int stationNumber,
			HttpServletResponse response) {
		List<FirestationDTO> firestations = specificEndPointsService.firestation(stationNumber);
		if (!firestations.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
		return "StationNumber: " + firestations;
	}

	@GetMapping("/childAlert")
	@ResponseBody
	public List<ChildAlertDTO> getAllChildren(@RequestParam(value = "address") final String address,
			HttpServletResponse response) {
		List<ChildAlertDTO> childAlerts = specificEndPointsService.childAlert(address);
		if (!childAlerts.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
//		return "Address: " + childAlerts;
		return childAlerts;
	}

	@GetMapping("/phoneAlert")
	@ResponseBody
	public String getPhoneNumberCoveredByStation(@RequestParam(value = "firestation") final int firestationNumber,
			HttpServletResponse response) {
		return "FirestationNumber: " + firestationNumber;
	}

	@GetMapping("/fire")
	@ResponseBody
	public String getPersonsByAddress(@RequestParam(value = "address") final String address,
			HttpServletResponse response) {
		return "Address: " + address;
	}

	@GetMapping("/flood/stations")
	@ResponseBody
	public String getHomeCoveredByStation(@RequestParam(value = "stations") final List<Integer> stations,
			HttpServletResponse response) {
		return "Stations: " + stations;
	}

	@GetMapping("/personInfo")
	@ResponseBody
	public List<PersonInfoDTO> getAllPerson(@RequestParam(value = "firstName") final String firstName,
			@RequestParam(value = "lastName") final String lastName, HttpServletResponse response) {
		List<PersonInfoDTO> personInfo = specificEndPointsService.personInfo(firstName, lastName);
		if (!personInfo.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
//		return "FirstName: " + firstName + "LastName: " + lastName;
		return personInfo;
	}

	@GetMapping("/communityEmail")
	@ResponseBody
	public List<String> getAllMail(@RequestParam(value = "city") final String city, HttpServletResponse response) {
		List<String> communityEmail = specificEndPointsService.communityEmail(city);
		if (!communityEmail.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
		}
//		return "City: " + communityEmail;
		return communityEmail;
	}

}
