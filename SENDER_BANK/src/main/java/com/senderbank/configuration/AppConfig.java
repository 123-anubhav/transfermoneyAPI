package com.senderbank.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.senderbank.entity.Account;

@Configuration
public class AppConfig {

	RestTemplate restTemplate;

	List<Object> result;

	@Bean
	public RestTemplate createRestTemplateObject() {
		System.out.println("\n========rest template object created============\n");
		return new RestTemplate();
	}
}
