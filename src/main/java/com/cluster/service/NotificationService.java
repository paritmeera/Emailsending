package com.cluster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cluster.entity.User;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}

	public void sendNotification(User user ) throws MailException{
		
		
		//send email
		SimpleMailMessage mail= new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("meeraparit@gmail.com");
		mail.setSubject("this is my first request!!!");
		mail.setText("This is a email notification");
		
		
		javaMailSender.send(mail);
	}
	
}
