package com.mat37.SafetyNet_Alerts.DTO;

import java.util.List;

import lombok.Data;

@Data
public class FirestationDTO {

	private final List<FirestationPersonDTO> firestationPersonDTO;
	private final int totalAdult;
	private final int totalChild;

}
