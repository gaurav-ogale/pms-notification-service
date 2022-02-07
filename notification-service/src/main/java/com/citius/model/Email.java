package com.citius.model;

public class Email {

	private String emailAddress;
	private String subject;
	private String emailBody;
	private String notificationServiceId;

	public Email() {
		// TODO Auto-generated constructor stub
	}

	public Email(String emailAddress, String subject, String emailBody, String notificationServiceId) {
		super();
		this.emailAddress = emailAddress;
		this.subject = subject;
		this.emailBody = emailBody;
		this.notificationServiceId = notificationServiceId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmailBody() {
		return emailBody;
	}

	public void setEmailBody(String emailBody) {
		this.emailBody = emailBody;
	}

	public String getNotificationServiceId() {
		return notificationServiceId;
	}

	public void setNotificationServiceId(String notificationServiceId) {
		this.notificationServiceId = notificationServiceId;
	}

}
