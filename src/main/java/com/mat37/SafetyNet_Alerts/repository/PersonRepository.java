package com.mat37.SafetyNet_Alerts.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mat37.SafetyNet_Alerts.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

	public List<Person> findByCity(String city);

	public List<Person> findByFirstNameAndLastName(String firstName, String lastName);

	public List<Person> findByLastName(String lastName);

}
