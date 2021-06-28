package com.mat37.SafetyNet_Alerts.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "firestations")
public class Firestation {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;

	private String address;
	private int stationNumber;

	public static String generateId(Firestation firestation) {
		return firestation.getAddress() + "_" + firestation.getStationNumber();
	}
}