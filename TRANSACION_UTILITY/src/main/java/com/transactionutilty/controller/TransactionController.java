package com.transactionutilty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestTemplate;

import com.transactionutilty.entity.Account;
import com.transactionutilty.entity.Transfer;
import com.transactionutilty.exception.UserException;
import com.transactionutilty.utilities.Util;

@RestController
@RequestMapping("/transactioncontroller")
@RestControllerAdvice
public class TransactionController {

	/*
	 * @Autowired IAccount iaccount;
	 * 
	 * @Autowired com.paytm.entity.repository.ITransfer itransfer;
	 */
	@Autowired
	RestTemplate restTemplate;


	@PostMapping("/transfer")
	@ExceptionHandler(UserException.class)
	public ResponseEntity<Transfer> /* String */ transferMoney(@RequestBody Transfer transfer) {

		System.out.println(transfer);
		Transfer fundTransfer = null;
		ResponseEntity<Account> forEntity = null;

		System.out.println("\n====== Transaction Utlity API CALL FROM Sender Bank's API =======\n" + transfer.toString());
		String url = "http://localhost:6767/recieverbank/getAmount";
		try {
			forEntity = restTemplate.postForEntity(url, transfer, Account.class);

			// store reciever's bank's details
			double toAccAmount = forEntity.getBody().getAmount();
			System.out.println("\namount recieved in Reciever Bank is " + toAccAmount);

		} catch (Exception e) {
			e.printStackTrace();
		}

		Util util = new Util();

		System.out.println(util.toString());
		try {
			fundTransfer = util.fundTransfer(transfer, forEntity.getBody());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		return new ResponseEntity<Transfer>(fundTransfer, HttpStatus.OK);

	}

}
