package com.cerner.patientPortalBackend.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.cerner.patientPortalBackend.model.Patient;

public interface PatientRepository extends MongoRepository<Patient,Long> {
/**
 * Different queries are defined as required since they are not part of the Repository from before.
 * 
 */
	
	List findByfirstNameIgnoreCase(String firstName);
	List findBylastNameIgnoreCase(String lastName);
	List findBydob(String dob);
	@Query("{'firstName' : {$regex : ?0, $options: 'i'}, 'lastName' : {$regex : ?1, $options: 'i'}}")
	List findByFirstNameAndLastNameAllIgnoreCase(String firstName, String lastName);
	@Query("{'firstName' : {$regex : ?0, $options: 'i'} , 'dob' : ?1}")
	List findByFirstNameIgnoreCaseAnddob(String firstName, String dob);
	@Query("{'lastName' : {$regex : ?0, $options: 'i'} , 'dob' : ?1}")
	List findBylastNameIgnoreCaseAnddob(String lastName, String dob);
	@Query("{'firstName' : {$regex : ?0, $options: 'i'} , 'lastName' : {$regex : ?1, $options: 'i'}, 'dob' : ?2}")
	List findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAnddob(String firstName, String lastName,String dob);
	@Query("{'id' : ?0 ,'firstName' : {$regex : ?1, $options: 'i'} , 'lastName' : {$regex : ?2, $options: 'i'}, 'dob' : ?3}")
	List findByIdFirstNameIgnoreCaseAndLastNameIgnoreCaseAnddob(Long id,String firstName, String lastName,String dob);
	
}
