package com.cerner.patientPortalBackend.model;

public class Address {
	private String city;
	private String state;
	private String country;
	private String addressLine1;
	private String addressLine2;
/**
 * Address has been made as a different class because it holds the relation of one-to-many as a single patient can
 *  have multiple address.
 */
	public Address(String city, String state, String country, String addressLine1, String addressLine2) {

		this.city = city;
		this.state = state;
		this.country = country;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", addressLine1=" + addressLine1
				+ ", addressLine2=" + addressLine2 + "]";
	}

}
