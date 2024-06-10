package org.maaProxyBack.dto;

public class AccountDto {
	long accountNumber;
	double balance;
	String type;
	String category;
	
	
	
	public AccountDto() {
		super();
	}

	public AccountDto(double balance, String type, String category) {
		this.balance = balance;
		this.type = type;
		this.category = category;
	}
	
	public AccountDto(long id,double balance, String type, String category) {
		this.accountNumber = id;
		this.balance = balance;
		this.type = type;
		this.category = category;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
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
