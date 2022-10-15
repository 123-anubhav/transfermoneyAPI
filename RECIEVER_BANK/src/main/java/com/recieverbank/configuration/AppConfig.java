package com.recieverbank.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	RestTemplate restTemplate;

	List<Object> result;

	/*
	 * @Bean public ResponseEntity<Account> outerCalling(@RequestBody Account
	 * account) { restTemplate = new RestTemplate(); //String url =
	 * "http://localhost:6767/createAccount"; //ResponseEntity<Account> forObject =
	 * restTemplate.getForEntity(url + "/{account}", Account.class); //return
	 * forObject; }
	 */
	@Bean
	public RestTemplate createRestTemplateObject() {
		System.out.println("\n========rest template object created============\n");
		return new RestTemplate();
	}
}
