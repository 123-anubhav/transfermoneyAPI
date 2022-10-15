package com.recieverbank.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITransfer extends JpaRepository<com.recieverbank.entity.Transfer, Integer> {

	// #{#HDFC_MONEY_TRANSFER}
	//@Query("select e.amountfromAcc from HDFC_MONEY_TRANSFER e where e.fromAcc=?")
	//public Double getamountfromAccbyfromAcc(@Param(value = "fromAcc") String fromAcc);

	 //public Transfer findamountfromAccByfromAcc(String fromAcc);
	 
	 //@Query("select e from HDFC_MONEY_TRANSFER e where e.fromAcc=?")
	 //public Transfer getamountfromAccByfromAcc(String fromAcc);
	
}
