package com.cluster.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cluster.entity.User;
import com.cluster.service.NotificationService;
@RestController
public class SimpleMailController {

	private Logger logger =LoggerFactory.getLogger(SimpleMailController.class);
	@Autowired
	private NotificationService notificationService; 
	@RequestMapping("/signup")
	public String signUp()
	{
		return "please sign up our service";
	}
	
	@RequestMapping("/signup-sucess")
	public String signupSucess()
	{
		
		User user = new User();
		user.setFirstName("meera");
		user.setLastName("parit");
		user.setEmailAddress("meeraparit@gmail.com");
		try {
		notificationService.sendNotification(user); 
		}
		
		catch(Exception e)
		{
			logger.info("Error for sending email:" +e.getMessage());
		}
		return "Thank you for registration with us:";
		
	}
}
