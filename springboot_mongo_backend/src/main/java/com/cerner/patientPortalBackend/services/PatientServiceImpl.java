package com.cerner.patientPortalBackend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import com.cerner.patientPortalBackend.dao.PatientRepository;
import com.cerner.patientPortalBackend.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImpl.class);
	int idCounter = 0;
	@Autowired
	private PatientRepository patientRepo;
/**
 * The method savePatient calls the save method of Mongo Repository to store the details of patients.
 */
	@Override
	public Patient savePatient(Patient patient) throws Exception {
		LOGGER.info("Create Patient");
		Patient patientSave;
		patient.setId(SequenceGeneratorService.generateSequence(Patient.SEQUENCE_NAME));
		try {
			patientSave = patientRepo.save(patient);
		}
		catch (DuplicateKeyException e) {
			LOGGER.info(e.getMessage());
			throw new DuplicateKeyException(e.getMessage());
		} 
		catch (Exception ex) {
			LOGGER.info(ex.getMessage());
			throw new Exception(ex.getMessage());
		}
		return patientSave;
	}
	/**
	 * getPatientList method calls different methods defined in Mongo Repository based on certain conditions.
	 */
	@Override
	public List<Patient> getPatientList(Long id,String firstName, String lastName,String dob) throws Exception {
	System.out.println(id);
	try {
		if((id==null || id.toString().isEmpty())&&(firstName==null||firstName.isEmpty())&&(lastName==null|| lastName.isEmpty())&&(dob==null || dob.isEmpty())) {
			System.out.println(patientRepo.findAll());
			return patientRepo.findAll();
	}
		else if(id !=null && !id.toString().isEmpty() &&(lastName==null||lastName.isEmpty())&&(dob==null||dob.isEmpty())) {
			LOGGER.info("finding by id");
			System.out.println(patientRepo.findById(id));
			Optional<Patient> patient=patientRepo.findById(id);
			//return patient;
			return patient.stream().collect(Collectors.toList());
		}
		else if(firstName!=null && !firstName.isEmpty() &&(lastName==null||lastName.isEmpty())&&(dob==null||dob.isEmpty()) ){
			LOGGER.info("finding by firstname");
			System.out.println(patientRepo.findByfirstNameIgnoreCase(firstName));
			return patientRepo.findByfirstNameIgnoreCase(firstName);
		}
		
		else if(lastName!=null && !lastName.isEmpty()&& (firstName==null||firstName.isEmpty() )&&(dob==null||dob.isEmpty())) {
			LOGGER.info("finding by lastname");
			System.out.println(patientRepo.findBylastNameIgnoreCase(lastName));
			return patientRepo.findBylastNameIgnoreCase(lastName);
		}
		else if(dob!=null && !dob.isEmpty() && (firstName==null||firstName.isEmpty() )&&(lastName==null||lastName.isEmpty())) {
			System.out.println("finding by dob");
			System.out.println(patientRepo.findBydob(dob));
			return patientRepo.findBydob(dob);
		}
		else if(firstName!=null && !firstName.isEmpty() && lastName!=null && !lastName.isEmpty()&& (dob==null || dob.isEmpty())&&(id==null || id.toString().isEmpty())) {
			LOGGER.info("finding by firstname and lastname");
			System.out.println(patientRepo.findByFirstNameAndLastNameAllIgnoreCase(firstName, lastName));
			return patientRepo.findByFirstNameAndLastNameAllIgnoreCase(firstName, lastName);
		}
		else if(firstName!=null &&!firstName.isEmpty() && (lastName==null || lastName.isEmpty())&& dob!=null && !dob.isEmpty()) {
			System.out.println("finding by firstname and lastname");
			System.out.println(patientRepo.findByFirstNameIgnoreCaseAnddob(firstName, dob));
			return patientRepo.findByFirstNameIgnoreCaseAnddob(firstName, dob);
		}
		else if(lastName!=null &&!lastName.isEmpty() && (firstName==null || firstName.isEmpty())&& dob!=null && !dob.isEmpty()) {
			LOGGER.info("finding by firstname and lastname");
			return patientRepo.findBylastNameIgnoreCaseAnddob(lastName, dob);
		}
		else if(firstName!=null && !firstName.isEmpty() && lastName!=null && !lastName.isEmpty() && dob!=null && !dob.isEmpty() && (id==null||id.toString().isEmpty())) {
			LOGGER.info("finding by firstname,lastname and dob");
			System.out.println(patientRepo.findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAnddob( firstName, lastName, dob)) ;
			return patientRepo.findByFirstNameIgnoreCaseAndLastNameIgnoreCaseAnddob( firstName, lastName, dob);
		}
		
		else {
			System.out.println(patientRepo.findByIdFirstNameIgnoreCaseAndLastNameIgnoreCaseAnddob(id, firstName, lastName, dob));
			return patientRepo.findByIdFirstNameIgnoreCaseAndLastNameIgnoreCaseAnddob(id, firstName, lastName, dob);
		}
			
	}
	catch(Exception ex) {
		LOGGER.info(ex.getMessage());
		throw new Exception(ex.getMessage());
	}
	}
	
}
