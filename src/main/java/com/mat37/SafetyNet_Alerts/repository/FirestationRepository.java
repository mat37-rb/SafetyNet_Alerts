package com.mat37.SafetyNet_Alerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mat37.SafetyNet_Alerts.model.Firestation;

@Repository
public interface FirestationRepository extends CrudRepository<Firestation, String> {

}
