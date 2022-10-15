package com.transactionutilty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="VIA_PAYTM_ACCOUNT")
public class Account {

	@Id
	@GeneratedValue
	private int id;

	@JsonProperty
	private String accountNumber;

	@JsonProperty
	private double amount;

	@JsonProperty
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", amount=" + amount + ", email=" + email + "]";
	}

}
