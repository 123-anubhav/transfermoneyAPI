package com.senderbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "HDFC_MONEY_TRANSFER")
public class Transfer {

	@Id
	@GeneratedValue
	private int id;

	private String fromAcc;
	private String toAcc;
	private String email;
	private double amountfromAcc;
	private double FromAccTotalAmount;
	private double toAccAmount; // jis account money transfer krna h uska total balance
	private String msg;

	public Transfer(String fromAcc, String toAcc, String email, double amountfromAcc, double fromAccTotalAmount,
			double toAccAmount, String msg, double transferAmount) {
		super();
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.email = email;
		this.amountfromAcc = amountfromAcc;
		FromAccTotalAmount = fromAccTotalAmount;
		this.toAccAmount = toAccAmount;
		this.msg = msg;
		this.transferAmount = transferAmount;
	}

	public double getAmountfromAcc() {
		return amountfromAcc;
	}

	public void setAmountfromAcc(@JsonProperty double amountfromAcc) {
		this.amountfromAcc = amountfromAcc;
	}

	public double getToAccAmount() {
		return toAccAmount;
	}

	public void setToAccAmount(@JsonProperty double toAccAmount) {
		this.toAccAmount = toAccAmount;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(@JsonProperty String msg) {
		this.msg = msg;
	}

	public double getFromAccTotalAmount() {
		return FromAccTotalAmount;
	}

	public void setFromAccTotalAmount(@JsonProperty double fromAccTotalAmount) {
		FromAccTotalAmount = fromAccTotalAmount;
	}

	public Transfer(String msg) {
		super();
		this.msg = msg;
	}

	public Transfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(@JsonProperty String email) {
		this.email = email;
	}

	private double transferAmount;

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

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(@JsonProperty double transferAmount) {
		this.transferAmount = transferAmount;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", fromAcc=" + fromAcc + ", toAcc=" + toAcc + ", email=" + email
				+ ", amountfromAcc=" + amountfromAcc + ", FromAccTotalAmount=" + FromAccTotalAmount + ", toAccAmount="
				+ toAccAmount + ", msg=" + msg + ", transferAmount=" + transferAmount + "]";
	}

}
