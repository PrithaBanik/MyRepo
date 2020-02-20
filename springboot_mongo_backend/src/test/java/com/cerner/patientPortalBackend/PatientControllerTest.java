//package com.cerner.patientPortalBackend;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertEquals;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import com.cerner.patientPortalBackend.controllers.PatientController;
//import com.cerner.patientPortalBackend.model.Address;
//import com.cerner.patientPortalBackend.model.Patient;
//import com.cerner.patientPortalBackend.services.PatientService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(PatientController.class)
//class PatientControllerTest {
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private PatientService patientService;
//
//	@Test
//	void testSavePatient() throws DuplicateKeyException, Exception {
//		Patient mockpatient = new Patient("111", "Pritha", "banik", "12.11.2019", "female", "a@gail.com",
//				new Address("ss", "india", "5a", "queens", "ww"));
//		Address address = new Address("ss", "india", "5a", "queens", "ww");
//		mockpatient.setfirstName("Pritha");
//		mockpatient.setlastName("Banik");
//		mockpatient.setDob("12.11.2019");
//		mockpatient.setGender("female");
//		mockpatient.setEmail("a@gail.com");
//		mockpatient.setId("12345");
//		address.setAddressLine1("ss");
//		address.setAddressLine1("india");
//		address.setCity("bangalore");
//		address.setCountry("queens");
//		address.setState("Karnataka");
//		String inputInJson = this.mapToJson(mockpatient);
//		String URI = "/add";
//		Mockito.when(patientService.savePatient(Mockito.any(Patient.class))).thenReturn(mockpatient);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
//				.content(inputInJson).contentType(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		MockHttpServletResponse response = result.getResponse();
//		String outputInJson=response.getContentAsString();
//		assertThat("Patient Registered With id 12345").isEqualTo(outputInJson);
//		assertEquals(HttpStatus.OK.value(), response.getStatus());
//	}
//
//	@Test
//	void testGetAll() throws Exception {
//		Patient p = new Patient("123", "pritha", "banik", "12.11.2019", "female", "a@gail.com",
//				new Address("ss", "india", "5a", "queens", "ww"));
//		Patient p1 = new Patient("123", "pritha", "banik", "12.11.2019", "female", "a@gail.com",
//				new Address("ss", "india", "5a", "queens", "ww"));
//		List<Patient> patientlist = new ArrayList<>();
//		patientlist.add(p);
//		patientlist.add(p1);
//		Mockito.when(patientService.getAll()).thenReturn(patientlist);
//		String URI = "/getAll";
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		String expectedJson = this.mapToJson(patientlist);
//		String outputInJson = result.getResponse().getContentAsString();
//		assertThat(outputInJson).isEqualTo(expectedJson);
//	}
//
//	@Test
//	void testGetPatient() throws Exception,RuntimeException {
//		String id = "123";
//		Patient p = new Patient("123", "pritha", "banik", "12.11.2019", "female", "a@gail.com",
//				new Address("ss", "india", "5a", "queens", "ww"));
//		Mockito.when(patientService.getPatient(Mockito.anyString())).thenReturn(Optional.of(p));
//		String URI = "/getPatient/123";
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON);
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//		String expectedJson = this.mapToJson(p);
//		String outputInJson = result.getResponse().getContentAsString();
//		assertThat(outputInJson).isEqualTo(expectedJson);
//	}
//
//	private String mapToJson(Object object) throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.writeValueAsString(object);
//	}
//
//}
