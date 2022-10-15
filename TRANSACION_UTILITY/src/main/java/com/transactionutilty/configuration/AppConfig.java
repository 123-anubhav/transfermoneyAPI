package com.transactionutilty.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.transactionutilty.entity.Transfer;
import com.transactionutilty.utilities.Util;

@Configuration
public class AppConfig {

	RestTemplate restTemplate;

	List<Object> result;

	
	@Bean
	public RestTemplate createRestTemplateObject() {
		System.out.println("\n========rest template object created from configuration class =========\n");
		return new RestTemplate();
	}

	@Bean
	public Util util() {
		System.out.println("\n========util object created from configuration class ==========\n");
		return new Util();
	}

	@Bean
	public Transfer transfer() {
		System.out.println("\n========transfer object created from configuration class============\n");
		return new Transfer();
	}
}


