package com.blazdemsar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	JavaMailSender  javaMailSender;

	public SimpleMailMessage sendEmail(String userName, String emailTo) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailTo);
		message.setCc("synergisfremont@gmail.com");
		message.setSubject("Test Bank Email");
		message.setText("Hi " + userName + "!\n\nThank you for registering with our Online Banking Application!" + "\n\nThank you and have a great day, "+ "\nBlazing Technologies");
		javaMailSender.send(message);
		
		return message;
		
	}
}
