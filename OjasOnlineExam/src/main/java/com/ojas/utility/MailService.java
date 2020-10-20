package com.ojas.utility;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

/**
 * 
 * @author kmahendra
 *
 */
@Component
public class MailService {
	public JavaMailSender mailProperties() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("smtp.gmail.com");
		sender.setUsername("unlock.delete@gmail.com");
		sender.setPassword("123123654");

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "456");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		prop.put("mail.smtp.starttls.enable", "true");
		sender.setJavaMailProperties(prop);
		return sender;
	}

	public void sendEmail(String to, String subject, String text) {
		JavaMailSenderImpl sender = (JavaMailSenderImpl) mailProperties();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(sender.getUsername());
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		// sending message
		sender.send(message);
	}

}
