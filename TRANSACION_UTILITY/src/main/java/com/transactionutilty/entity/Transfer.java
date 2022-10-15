package com.transactionutilty.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "moneyTransferviapaytm")
public class Transfer {

	@Id
	@GeneratedValue
	private int id;

	private String fromAcc; // jisse trnsfer krna h
	private String toAcc; // jisko trnsfer krna h
	private String email; // jisse money trnsfer ho ra h vo account ki email
	private double amountfromAcc; // jo paisa transfer krna h like 500 transfer krna h
	private double/* Double */ toAccAmount; // jis account money transfer krna h uska total balance
	private String msg; // either success or fail transaction
	private double/* Double */ fromAccTotalAmount; // from acc total paisa
	private double/* Double */ transferAmount;

	public Transfer(int id, String fromAcc, String toAcc, String email, double amountfromAcc, double toAccAmount,
			String msg, double fromAccTotalAmount, double transferAmount) {
		super();
		this.id = id;
		this.fromAcc = fromAcc;
		this.toAcc = toAcc;
		this.email = email;
		this.amountfromAcc = amountfromAcc;
		this.toAccAmount = toAccAmount;
		this.msg = msg;
		this.fromAccTotalAmount = fromAccTotalAmount;
		this.transferAmount = transferAmount;
	}

	
	public double getFromAccTotalAmount() {
		return fromAccTotalAmount;
	}

	public void setFromAccTotalAmount(@JsonProperty double fromAccTotalAmount) {
		System.out.println("***** setFromAccTotalAmount call  *****");
		this.fromAccTotalAmount = fromAccTotalAmount;
	}

	public Transfer(String msg) {
		super();
		this.msg = msg;
	}

	public double getToAccAmount() {
		return toAccAmount;
	}

	public void setToAccAmount(@JsonProperty double toAccAmount) {
		this.toAccAmount = toAccAmount;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", fromAcc=" + fromAcc + ", toAcc=" + toAcc + ", email=" + email
				+ ", amountfromAcc=" + amountfromAcc + ", toAccAmount=" + toAccAmount + ", msg=" + msg
				+ ", transferAmount=" + transferAmount + "]";
	}

	public double getAmountfromAcc() {
		return amountfromAcc;
	}

	public void setAmountfromAcc(@JsonProperty double amountfromAcc) {
		this.amountfromAcc = amountfromAcc;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(@JsonProperty String email) {
		this.email = email;
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

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(@JsonProperty double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public Transfer() {
		super();

		// TODO Auto-generated constructor stub
	}

}
