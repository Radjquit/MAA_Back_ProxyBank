package org.maaProxyBack.dto;

public class AccountDto {
	long id;
	double balance;
	String type;
	String category;
	
	public AccountDto(double balance, String type, String category) {
		this.balance = balance;
		this.type = type;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "AccountDto [balance=" + balance + ", type=" + type + ", category=" + category + "]";
	}
	
	
	
}
