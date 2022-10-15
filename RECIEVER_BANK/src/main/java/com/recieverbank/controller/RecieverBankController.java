package com.recieverbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recieverbank.entity.Account;
import com.recieverbank.entity.Transfer;
import com.recieverbank.entity.repository.IAccount;
import com.recieverbank.exception.UserException;

@RestController
@RequestMapping("/recieverbank")
@RestControllerAdvice
public class RecieverBankController {

	@Autowired
	IAccount iaccount;

	static Account findByaccountNumber;
	static ResponseEntity<Transfer> postForEntity /* = null */;

	@PostMapping("/createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		System.out.println("\n============FROM Sender Bank to ICICI Reciever Bank API CALL=========\n");
		Account save = iaccount.save(account);
		return new ResponseEntity<Account>(save, HttpStatus.OK);
	}

	@ExceptionHandler(UserException.class)
	@PostMapping("/getAmount")
	
	public ResponseEntity<Account>/* Account */ getamount(@RequestBody /* @JsonProperty */ Transfer money) {
		System.out.println("\n=====  CALL Reciever BANK's API VIA Transaction Utility  ===== \n JSON data from Transaction Utility \n"
				+ "	****	 " + money.toString() + "	********\n");
		findByaccountNumber = iaccount.findByaccountNumber(money.getToAcc());
		System.out.println(findByaccountNumber.toString());


		return new ResponseEntity<Account>(findByaccountNumber, HttpStatus.OK);

	}

	// api test in postman
	@PostMapping("/updateTcAccBalance")
	public String updateTcAccBalance(@RequestBody Transfer transfer) {

		// after successful transaction save updated amount to reciever's bank account

		try {
			findByaccountNumber.setAccountNumber(transfer.getToAcc());
			findByaccountNumber.setAmount(transfer.getToAccAmount());
			System.out.println(findByaccountNumber.toString());
			iaccount.save(findByaccountNumber);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "successfully to acc balance update in db";

	}

}
