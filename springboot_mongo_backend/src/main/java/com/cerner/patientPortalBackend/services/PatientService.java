package com.cerner.patientPortalBackend.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.cerner.patientPortalBackend.model.Patient;
/**
 * 
 * @author PB077048
 *	PatientService is an interface that declares different methods that are implemented in the PAtientServiceImpl class.
 */
@Service
public interface PatientService {
	Patient savePatient(Patient patient) throws IOException, Exception;
	List<Patient> getPatientList(Long id, String firstName, String lastName, String dob) throws Exception;
}
