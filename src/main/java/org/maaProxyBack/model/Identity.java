package org.maaProxyBack.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class Identity {
	
	private String firstName;

	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Identity [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
}
