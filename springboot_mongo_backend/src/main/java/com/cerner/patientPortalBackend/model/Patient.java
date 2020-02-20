package com.cerner.patientPortalBackend.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * 
 * @author PB077048
 *Model class Patient for collection Patient in MongoDB
 */
@Document(collection = "Patient")
@CompoundIndex(name = "firstName_lastName_dob", def = "{'firstName' : 1, 'lastName' : 1,'dob' : 1}", unique = true)
public class Patient {
/**
 * Generally mongoDB generates object id which is of type string it is changed to a sequence of type long for readability.	
 */
	 @Transient
	    public static final String SEQUENCE_NAME = "users_sequence";
	@Id
	private long id;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private String email;
	private Address address;
/**
 * Contructor defined for the different inputs.
 * 
 */
	public Patient(long id, String firstName, String lastName, String dob, String gender, String email,
			Address address) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.address = address;
	}
	/**
	 * Getters and Setters implemented.
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", gender=" + gender + ", email=" + email + ", address=" + address + "]";
	}
}
