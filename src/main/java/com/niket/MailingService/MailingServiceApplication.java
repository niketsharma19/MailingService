package com.niket.MailingService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
public class MailingServiceApplication {

	@Autowired
	JavaMailSender mailSender;

	public static void main(String[] args) {
		SpringApplication.run(MailingServiceApplication.class, args);
	}

	@PostConstruct
	public void init() {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			// Setting up necessary details
			mailMessage.setFrom("niketsharma22@gmail.com");
			mailMessage.setTo("niketsharma22@gmail.com");
			mailMessage.setText("Hello Mail!!");
			mailMessage.setSubject("Hello Mail");
			mailSender.send(mailMessage);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
