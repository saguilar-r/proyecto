package com.springboot.siicoreapp.models.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String from, String subject, String body) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(from);
        mailMessage.setCc(new String[] 
        		{"internacionaldepartes20@gmail.com "
        			,"autoscolombia35@gmail.com"
        			,"pcarbon@carbon.com.co"
        			,"importsa@imps.com.co"
        			,"sergar049@gmail.com"
        			,"sergioaguilaras@gmail.com"});
        mailMessage.setSubject(subject);
        mailMessage.setText(body);

        javaMailSender.send(mailMessage);
    }
}
