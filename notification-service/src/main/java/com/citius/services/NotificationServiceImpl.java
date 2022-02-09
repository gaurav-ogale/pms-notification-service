package com.citius.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.citius.model.Email;

@Service
public class NotificationServiceImpl implements NotificationService {

	private JavaMailSender javaMailSender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private MailProperties mailProperties;

	@Value("${spring.mail.username}")
	String fromUser;

	@Autowired
	public NotificationServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Async
	public void sendHtmlMail(String to, String subject, String templateName, Context context)
			throws MessagingException, javax.mail.MessagingException {
		MimeMessage mail = javaMailSender.createMimeMessage();

		String body = templateEngine.process(templateName, context);
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setTo(to);
		helper.setFrom(fromUser);
		helper.setSubject(subject);

		helper.setText(body, true);
		javaMailSender.send(mail);

	}

	@Override
	public String getNotificationType(Email email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendEmail(Email email) {
		Context context = new Context();
		context.setVariable("UserName", email.getEmailAddress());
		context.setVariable("Subject", email.getSubject());

		try {
			sendHtmlMail(email.getEmailAddress(), email.getSubject(), "email-notification", context);
		} catch (MessagingException e) {
			// log.error("error in sendForgotPasswordEmail" + e);
		}

	}

	@Override
	public String forgetPasswordNotification(String userName, String defaultPass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
