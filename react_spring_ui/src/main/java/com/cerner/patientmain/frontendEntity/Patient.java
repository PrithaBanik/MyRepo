package com.cerner.patientmain.frontendEntity;

/**
 * 
 * @author PB077048
 *Patient class helps to send the data in the exact format how it is to be received in the backend 
 */
public class Patient {
	
	 private String id;
	 public String firstName;
	 public String lastName;
	 public String dob;
	 public String gender;
	 public String email;
	 public Address address;
	 /**
	  * Contructor defined for the different inputs.
	  * 
	  */	 
	public Patient(String id, String firstName, String lastName, String dob, String gender, String email,
			Address address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.email = email;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
