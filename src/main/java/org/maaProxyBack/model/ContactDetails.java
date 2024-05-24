package org.maaProxyBack.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class ContactDetails {
	
	private String mail;
	private String phoneNumber;
	private String address;
	private String city;
	private String postalCode;
	
	public String getMail() {
		return mail;
	}
	
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "ContactDetails [mail=" + mail + ", phoneNumber=" + phoneNumber + ", address=" + address + ", city=" + city
				+ ", postalCode=" + postalCode + "]";
	}
	
	
	

}
