package org.maaProxyBack.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String label;
	private  Double amount;
	private Date transDate;
	
	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JsonIgnore
	@JoinColumn(name = "account_id")
	private Account account;

	public Transaction(Long id, String label, Double amount, Date dateTransac) {
		this.id = id;
		this.label = label;
		this.amount = amount;
		this.transDate = dateTransac;
	}
	
	public Transaction() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", label=" + label + ", amount=" + amount + ", transDate=" + transDate
				+ ", account=" + account + "]";
	}
	
	
}
