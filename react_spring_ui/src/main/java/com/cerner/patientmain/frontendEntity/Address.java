package com.cerner.patientmain.frontendEntity;
/**
 * 
 * @author PB077048
 *Address class helps to send the data in the exact format how it is to be received in the backend 
 */
public class Address {
	private String city;
	private String state;
	private String country;
	private String addressLine1;
	private String addressLine2;
	
	public Address(String city, String state, String country, String addressLine1, String addressLine2) {
		//super();
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
