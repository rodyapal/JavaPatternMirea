package com.example.task17_criteria_api.services;

import com.example.task17_criteria_api.model.entity.Student;
import com.example.task17_criteria_api.service.EmailService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@ExtendWith(MockitoExtension.class)
public class EmailServiceTest {
	@Mock
	private JavaMailSenderImpl mailSender;
	private EmailService emailService;

	@BeforeEach
	public void setUp() {
		this.emailService = new EmailService(mailSender);
	}

	@Test
	public void testSendNotification() {
		Student student = new Student("TestFirstName", "TestLastName", "TestMiddleName", -1L, null, -1L);
		Mockito.doNothing().when(mailSender).send(Mockito.any(SimpleMailMessage.class));
		emailService.sendNotification(student);
		Mockito.verify(mailSender).send(Mockito.any(SimpleMailMessage.class));
	}
}
