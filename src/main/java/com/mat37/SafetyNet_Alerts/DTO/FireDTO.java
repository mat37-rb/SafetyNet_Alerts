package com.mat37.SafetyNet_Alerts.DTO;

import java.util.List;

import lombok.Data;

@Data
public class FireDTO {

	private final List<FirePersonDTO> firePersonDTO;
	private final List<Integer> stationNumber;

}
