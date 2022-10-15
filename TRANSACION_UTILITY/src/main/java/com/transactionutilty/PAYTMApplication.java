package com.transactionutilty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class PAYTMApplication {

	public static void main(String[] args) {
		SpringApplication.run(PAYTMApplication.class, args);
	}

}
