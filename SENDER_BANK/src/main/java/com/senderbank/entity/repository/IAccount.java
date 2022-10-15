package com.senderbank.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senderbank.entity.Account;

public interface IAccount extends JpaRepository<Account, Integer> {

	// copy from icici bank same chij chahiye
	// @Query("select e.amount from ICICI_BANK_ACCOUNT e where e.accountNumber=?")
	public Account findByaccountNumber(String accountNumber);

}
