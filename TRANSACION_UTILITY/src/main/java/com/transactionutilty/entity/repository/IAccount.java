package com.transactionutilty.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transactionutilty.entity.Account;

public interface IAccount extends JpaRepository<Account, Integer> {

}
