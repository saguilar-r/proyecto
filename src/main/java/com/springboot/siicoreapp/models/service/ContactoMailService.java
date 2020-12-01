package com.springboot.siicoreapp.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ContactoMailService {
	
	   @Autowired
	    private JavaMailSender javaMailSenders;

	    public void sendMails(String from, String subject, String body) {

	        SimpleMailMessage mailMessages = new SimpleMailMessage();

	        mailMessages.setFrom(from);
	        mailMessages.setTo("websiicore@gmail.com");
	        mailMessages.setSubject(subject);
	        mailMessages.setText(body);

	        javaMailSenders.send(mailMessages);
	    }

}
