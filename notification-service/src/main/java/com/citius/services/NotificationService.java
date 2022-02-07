package com.citius.services;

import com.citius.model.Email;

public interface NotificationService {

	public String getNotificationType(Email email);
	public void sendEmail(Email email);

}
