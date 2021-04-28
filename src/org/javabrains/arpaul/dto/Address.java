package org.javabrains.arpaul.dto;

import javax.persistence.Embeddable;

@Embeddable // Inform hibernate that no new table is required for this object
public class Address {

	private String Street;
	private String city;
	private String state;
	private String pincode;
	
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
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
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
