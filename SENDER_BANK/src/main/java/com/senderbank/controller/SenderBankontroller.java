package com.senderbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.senderbank.entity.Account;
import com.senderbank.entity.Transfer;
import com.senderbank.entity.repository.IAccount;
import com.senderbank.entity.repository.ITransfer;

@RestController
@RequestMapping("/senderbank")
public class SenderBankontroller {

	@Autowired
	IAccount iaccount;

	@Autowired
	ITransfer itransfer;

	@Autowired
	RestTemplate restTemplate;


	static ResponseEntity<Transfer> postForEntity;

	@PostMapping("/createAccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account save = iaccount.save(account);
		return new ResponseEntity<Account>(save, HttpStatus.OK);
	}

	

	@PostMapping("/transferFund")
	public /* ResponseEntity<String> */ ResponseEntity<Transfer> transfer(@RequestBody Transfer money) {

		System.out.println("\n" + money.toString() + "\n");

		//sender bank api call
		Account findByaccountNumber = iaccount.findByaccountNumber(money.getFromAcc());
		System.out.println(findByaccountNumber.toString());
		System.out.println("from acc amount total " + findByaccountNumber.getAmount());

		money.setFromAccTotalAmount(findByaccountNumber.getAmount());

		System.out.println("\n============== SENDER BANK TransferFund  api call ============\n");
		String url = "http://localhost:6666/transactionutility/transfer";

		try {
			postForEntity = (restTemplate.postForEntity(url, money, Transfer.class));

			// after successful transaction from sender update amount to sender's bank db

			findByaccountNumber.setAccountNumber(postForEntity.getBody().getFromAcc());
			findByaccountNumber.setAmount(postForEntity.getBody().getFromAccTotalAmount());
			iaccount.save(findByaccountNumber);

			
			double toAcctotal = postForEntity.getBody().getToAccAmount();
			double trans = postForEntity.getBody().getAmountfromAcc();
			
			postForEntity.getBody().setToAccAmount(toAcctotal + trans);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Transfer>(postForEntity.getBody(), HttpStatus.OK);
		
	}

	public String updateTcAccBalance() {
		String url = "http://localhost:6767/recieverbank/updateTcAccBalance";

		ResponseEntity<String> postForEntity2 = restTemplate.postForEntity(url, postForEntity.getBody(), String.class);
		return postForEntity2 + "successfully to acc balance update in db";
	}

}
