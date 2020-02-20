//package com.cerner.patientPortalBackend;
//
//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.assertEquals;
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
//import org.springframework.test.context.junit4.SpringRunner;
//import com.cerner.patientPortalBackend.dao.PatientRepository;
//import com.cerner.patientPortalBackend.model.Address;
//import com.cerner.patientPortalBackend.model.Patient;
//import com.cerner.patientPortalBackend.services.PatientService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(PatientService.class)
//class PatientServiceTests {
//
//	@Autowired
//	private PatientService pservice;
//
//	@MockBean
//	private PatientRepository prepo;
//
//	@Test
//	public void getPatientTest()throws Exception,DuplicateKeyException  {
//		String id = "123";
//		Mockito.when(prepo.findById(id)).thenReturn(Optional.of(new Patient("123", "pritha", "banik", "12.11.2019", "female",
//				"a@gail.com", new Address("ss", "india", "5a", "queens", "ww"))));
//		assertTrue(pservice.getPatient(id).isPresent());
//	}
//
//	@Test
//	public void savePatientTest() throws Exception {
//		Patient patient = new Patient("111", "Anna", "Pandey", "ap@gmail.com", "11.11.2011", "female",
//				new Address("ss", "india", "5a", "queens", "ww"));
//		Mockito.when(prepo.save(patient)).thenReturn(patient);
//		assertEquals(patient, pservice.savePatient(patient));
//	}
//	@Test
//	public void getAllPatientTest()throws Exception { 
//		Patient patient = new Patient("123", "pritha", "banik", "12.11.2019", "female", "a@gail.com",
//				new Address("ss", "india", "5a", "queens", "ww"));
//		Patient patient1=new Patient("123", "pritha", "banik", "12.11.2019", "female", "a@gail.com",
//						new Address("ss", "india", "5a", "queens", "ww"));
//		List<Patient> patientlist = new ArrayList<>();
//		patientlist.add(patient);
//		patientlist.add(patient1);
//		Mockito.when(prepo.findAll()).thenReturn(patientlist);
//		assertTrue(pservice.getAll().equals(patientlist));
//	}
//
//}
