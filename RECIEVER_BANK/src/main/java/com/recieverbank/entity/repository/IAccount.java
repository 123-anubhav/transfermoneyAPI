package com.recieverbank.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.recieverbank.entity.Account;

@Repository
public interface IAccount extends JpaRepository<Account, Integer> {

	// @Query("select e.amount from ICICI_BANK_ACCOUNT e where e.accountNumber=?")
	public Account findByaccountNumber(String accountNumber);
	
	

}
