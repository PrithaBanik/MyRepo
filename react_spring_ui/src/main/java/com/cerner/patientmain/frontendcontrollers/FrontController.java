package com.cerner.patientmain.frontendcontrollers;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import com.cerner.patientmain.frontendEntity.Patient;
/**
 * 
 * @author PB077048
 *FrontController class is defined to pass data from the UI to the backend controllers. The data is not passed directly to
 * the api so that it is safe and not vulnerable to attacks.
 *
 */
@RestController
@CrossOrigin(origins = "*")
public class FrontController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FrontController.class);
	@Autowired
	RestTemplate restTemplate;
/**
 * RestTemplate is used to make a call to the api for saving patient details.
 */
	@RequestMapping("/addPatient")
	public String Register(@RequestHeader(value="Accept-Language") String acceptLang,@RequestBody Patient patient) throws Exception {
		ResponseEntity str = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setAcceptLanguageAsLocales( Arrays.asList( new Locale(acceptLang) ) );
		HttpEntity<Patient> entity = new HttpEntity<Patient>(patient, headers);

		if ((patient.getfirstName().equals("")) || (patient.getlastName().equals("")) || (patient.getDob().equals(""))
				|| (patient.getGender().equals(""))) {
			LOGGER.info("Fields cannot be null");
			throw new RuntimeException("Fields cannot be null");
		}
		try {
			LOGGER.info("Make a call to the api to save details.");
			str = restTemplate.postForEntity("http://localhost:8080/add", entity, String.class);
		} catch (ResourceAccessException ex) {
			LOGGER.info(ex.getMessage());
			return "Server is down.Please check if the server is working";
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			return "Check logs to see if something went wrong";
		}
		if (str.getBody().equals("Records with same Firstname,Lastname and D.O.B already exists")) {
			return (String) str.getBody();
		} else {
			return (String) str.getBody();
		}

	}
/**
* RestTemplate is used to make a call to the api for retrieving patient details.
 */
	@RequestMapping("/searchByIdFirstNameLastNameDob")
	public String getByIdFirstNameLastNameDob(@RequestParam (required=false)String id,@RequestParam(required=false) String firstName,@RequestParam(required=false) String lastName,@RequestParam(required=false) String dob) throws IOException {
		String getByIdFirstNameLastNameDob = "";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		try {
			LOGGER.info("Make a call to the api to get details of all patients.");
			String url = "http://localhost:8080/getPatientsByIdFirstNameLastNameDob/?id={idValue}&firstName={fnameValue}&lastName={lnameValue}&dob={dobValue}";
			Map<String, String> uriVariables = new HashMap();
			uriVariables.put("idValue", id);
			uriVariables.put("fnameValue", firstName);
			uriVariables.put("lnameValue", lastName);
			uriVariables.put("dobValue", dob);
			getByIdFirstNameLastNameDob=restTemplate.getForEntity(url, String.class, uriVariables).getBody();
			System.out.println(getByIdFirstNameLastNameDob);
			if (getByIdFirstNameLastNameDob.equals("[]")) {
				return "No patients available";
			} else {
				return getByIdFirstNameLastNameDob;
			}
		} catch (HttpServerErrorException eex) {
			LOGGER.info(eex.getMessage());
			return "Patient Not Found";
		} catch (ResourceAccessException ex) {
			LOGGER.info(ex.getMessage());
			return "Server is down.Please check if the server is working";
		} catch (Exception e) {
			LOGGER.info(e.getMessage());
			return "Check logs to see if something went wrong";
		}
		

	}
}
