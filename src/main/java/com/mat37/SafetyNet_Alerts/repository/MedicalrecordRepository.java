package com.mat37.SafetyNet_Alerts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mat37.SafetyNet_Alerts.model.Medicalrecord;

@Repository
public interface MedicalrecordRepository extends CrudRepository<Medicalrecord, String> {

	List<Medicalrecord> findByFirstNameAndLastName(String firstName, String lastName);

	List<Medicalrecord> findByLastName(String lastName);

	List<Medicalrecord> findByLastNameIn(List<String> lastName);

}
