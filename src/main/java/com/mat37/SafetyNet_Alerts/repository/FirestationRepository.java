package com.mat37.SafetyNet_Alerts.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mat37.SafetyNet_Alerts.model.Firestation;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, String> {

	List<Firestation> findByStationNumber(int stationNumber);

	List<Firestation> findByStationNumberIn(List<Integer> stationNumber);

	List<Firestation> findByAddress(String address);

	List<Firestation> findByAddressIn(Collection<String> address);

}
