package com.transactionutilty.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailSenderService {
	
	@Autowired
	JavaMailSender mailsender;
	
	//simple mail
	  public String sendMail(String toEmail, String subject, String body) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("anubhav.aa2@gmail.com");
		msg.setTo(toEmail);
		msg.setSubject(subject);
		msg.setText(body);
		mailsender.send(msg);
		System.out.println("mail send successfully");
		return "mail send successfully";

	}


}
