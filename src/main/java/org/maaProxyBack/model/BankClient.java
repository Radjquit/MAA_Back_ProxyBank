package org.maaProxyBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class BankClient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Valid
	@Embedded
	private Identity identity = new Identity();
	
	@Embedded
	private ContactDetails contactDetails;

	@OneToMany(mappedBy = "client",cascade = CascadeType.PERSIST)
	//@JsonIgnore
	private Set<SavingAccount> savingAccounts = new HashSet<>();

	@OneToMany(mappedBy = "client",cascade = CascadeType.PERSIST)
	//@JsonIgnore
	private Set<CurrentAccount> currentAccounts = new HashSet<>();

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnore
	@JoinColumn(name = "advisor_id")
	private Advisor advisor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Identity getIdentity() {
		return identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(ContactDetails contactDetails) {
		this.contactDetails = contactDetails;
	}

	public Set<SavingAccount> getSavingAccounts() {
		return savingAccounts;
	}

	public void setSavingAccounts(Set<SavingAccount> savingAccounts) {
		this.savingAccounts = savingAccounts;
	}

	public Set<CurrentAccount> getCurrentAccounts() {
		return currentAccounts;
	}

	public void setCurrentAccounts(Set<CurrentAccount> currentAccounts) {
		this.currentAccounts = currentAccounts;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	@Override
	public String toString() {
		return "BankClient [id=" + id + ", identity=" + identity + ", contactDetails=" + contactDetails
				+ ", savingAccounts=" + savingAccounts + ", currentAccounts=" + currentAccounts + ", advisor=" + advisor
				+ "]";
	}




	
	

}
