package com.example.task17_criteria_api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
@Slf4j
public class EmailService {
	private final String EMAIL = "grisha.omegon@yandex.ru";
	private final JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Async
	public void sendNotification(Object o) throws MailException {
		log.info("Sending email");
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(EMAIL);
		mail.setFrom(EMAIL);
		mail.setSubject("Save new " + o.getClass().getSimpleName() + " at " + DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)
				.format(LocalDateTime.now()));
		mail.setText(o.toString());

		javaMailSender.send(mail);
		log.info("Email sent");
	}
}
