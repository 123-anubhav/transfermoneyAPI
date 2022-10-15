package com.recieverbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "HDFC_MONEY_TRANSFER")
//@JsonDeserialize(builder = Transfer.class)
public class Transfer {

	@Id
	@GeneratedValue
	private int id;

	// @JsonProperty
	private String fromAcc; // jisse transfer ho ra h
	// @JsonProperty
	private String toAcc; // jisme transfer krna h
	// @JsonProperty
	private String email; // jisse transfer ho ra h usi email
	// @JsonProperty
	private double amountfromAcc; // jo paisa transfer ho ra h
	// @JsonProperty
	private String msg; // return either success or fail

	private double toAccAmount;

	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transfer(String fromAcc, String toAcc, String email, double amountfromAcc, String msg, double toAccAmount) {
		super();
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.email = email;
		this.amountfromAcc = amountfromAcc;
		this.msg = msg;
		this.toAccAmount = toAccAmount;
	}

	public String getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(@JsonProperty String fromAcc) {
		this.fromAcc = fromAcc;
	}

	public String getToAcc() {
		return toAcc;
	}

	public void setToAcc(@JsonProperty String toAcc) {
		this.toAcc = toAcc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(@JsonProperty String email) {
		this.email = email;
	}

	public double getAmountfromAcc() {
		return amountfromAcc;
	}

	public void setAmountfromAcc(@JsonProperty double amountfromAcc) {
		this.amountfromAcc = amountfromAcc;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(@JsonProperty String msg) {
		this.msg = msg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getToAccAmount() {
		return toAccAmount;
	}

	public void setToAccAmount(@JsonProperty double toAccAmount) {
		this.toAccAmount = toAccAmount;
	}

}
