package com.citius.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.citius.model.Email;
import com.citius.services.NotificationService;

@RestController
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@PostMapping
	public String getEmailDetails(@RequestBody Email email){
		notificationService.sendEmail(email);
		return "Success";
	}

}
