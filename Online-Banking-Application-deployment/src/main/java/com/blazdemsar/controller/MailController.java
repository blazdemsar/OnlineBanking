package com.blazdemsar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blazdemsar.service.MailService;

@Controller
public class MailController {
	
	@Autowired
	MailService mailService;
	
	@RequestMapping(value="sendEmail")
	public ResponseEntity<String> sendEmail(){
		/*
		mailService.sendEmail();
		return new ResponseEntity<String>("Email has been sent.", HttpStatus.OK);
		*/
		
		/*
		 * SimpleMailMessage message = mailService.sendEmail(); String to =""; int i =
		 * 0; for(String str : message.getTo()) { i++; to = to+"<br>"+ i+". "+str;
		 * 
		 * }
		 */
		return new ResponseEntity<String>("Email has been sent!", HttpStatus.OK);
	}
}
