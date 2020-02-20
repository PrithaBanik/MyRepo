package com.cerner.patientPortalBackend.controllers;

import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cerner.patientPortalBackend.model.Patient;
import com.cerner.patientPortalBackend.services.PatientService;
import com.cerner.patientPortalBackend.services.SequenceGeneratorService;

@RestController
@CrossOrigin(origins = "*")
/**
 * @author PB077048
 *PatientController class is the controller in the MVC architecture. It is used to exchange data between the frontend 
 *and the backend.
 */
public class PatientController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientController.class);
	@Autowired
	private PatientService pservice;
	@Autowired
    MessageSource messageSource;
/**
 * The add api,saves the details of every patient in the database.
 */
	@PostMapping("/add")
	public String savePatient(@RequestHeader(value="Accept-Language") String acceptLang, @RequestBody Patient patient) throws Exception {
		long idPatient ;
		
		System.out.println("lang: "+acceptLang);
		try {
			idPatient = pservice.savePatient(patient).getId();
		} catch (DuplicateKeyException e) {
			LOGGER.info(e.getMessage());
			return ("Records with same Firstname,Lastname and D.O.B already exists");
		}
		catch (Exception ex) {
			LOGGER.info(ex.getMessage());
			return ("Check logs to see if something went wrong");
		}
		LOGGER.info("Save Patient");
		Locale locale=new Locale(acceptLang);
		return messageSource.getMessage("register", null, locale)+idPatient;
	}
/**
 * The api getPatientsByIdFirstNameLastNameDob is used to filter data from the database based on whatever input is given
 *  by the user.
 */
	@GetMapping("/getPatientsByIdFirstNameLastNameDob")
	public List<Patient> getPatients(@RequestParam (required=false)Long id,@RequestParam(required=false) String firstName,@RequestParam(required=false) String lastName,@RequestParam(required=false) String dob) throws Exception {
		System.out.println(id);
		List<Patient> getPatientsByIdFirstNameLastNameDob = null;
		LOGGER.info("Retrieve Patient based on id Firstname,Lastname and dob");
		try {
		getPatientsByIdFirstNameLastNameDob = pservice.getPatientList(id, firstName, lastName, dob);
		}
		catch (RuntimeException ex) {
			LOGGER.info(ex.getMessage());
			throw new RuntimeException("Patient not found");
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			throw new Exception("Check logs to see if something went wrong");

		}
		if(getPatientsByIdFirstNameLastNameDob.toString().equals("[]")) {
			throw new RuntimeException("Patient not found");
		}
		else {
		return getPatientsByIdFirstNameLastNameDob;
		}
	}
}
