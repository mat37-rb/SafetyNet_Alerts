package com.mat37.SafetyNet.Alerts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mat37.SafetyNet.Alerts.model.Medicalrecord;

@Repository
public interface MedicalrecordRepository extends CrudRepository<Medicalrecord, Long> {

}
