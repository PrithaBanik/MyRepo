package com.cerner.patientmain.frontendcontrollers;

import java.net.URI;
import java.net.URISyntaxException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import com.cerner.patientmain.frontendEntity.Address;
import com.cerner.patientmain.frontendEntity.Patient;
import junit.framework.Assert;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FrontControllerTest<PatientController> {

//	@Autowired
//	private TestRestTemplate restTemplate;
//
//	@Test
//	public void testAddPatientSuccess() throws URISyntaxException {
//		final String baseUrl = "http://localhost:8080" + "/add/";
//		URI uri = new URI(baseUrl);
//		Patient patient = new Patient("111", "Pritha", "banik", "12.11.2019", "female", "a@gail.com",
//				new Address("ss", "5a", "queens", "ww", "india"));
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<Patient> request = new HttpEntity<>(patient, headers);
//		ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
//		System.out.println(result);
//		// Verify request succeed
//		Assert.assertEquals(200, result.getStatusCodeValue());
//	}
//
//	@Test
//	public void testGetPatientSuccess() throws URISyntaxException {
//		final String baseUrl = "http://localhost:8080" + "/getAll/";
//		URI uri = new URI(baseUrl);
//		HttpHeaders headers = new HttpHeaders();
//		ResponseEntity<String> result = this.restTemplate.getForEntity(uri, String.class);
//		System.out.println(result);
//		Assert.assertEquals(200, result.getStatusCodeValue());
//	}
//
//	@Test
//	public void testGetPatientByIdSuccess() throws URISyntaxException {
//		final String baseUrl = "http://localhost:8080/getPatient/111";
//		URI uri = new URI(baseUrl);
//		Patient patient = new Patient("111", "Pritha", "banik", "12.11.2019", "female", "a@gail.com",
//				new Address("ss", "india", "5a", "queens", "ww"));
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(headers);
//		ResponseEntity<String> result = this.restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
//		System.out.println(result);
//		Assert.assertEquals(200, result.getStatusCodeValue());
//	}
}
