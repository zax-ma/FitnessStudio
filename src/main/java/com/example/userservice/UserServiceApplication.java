package com.example.userservice;

import com.example.userservice.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class})
public class UserServiceApplication  {

	//implements ApplicationRunner

	@Autowired
//	private EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

/*	@Override
	public void run(ApplicationArguments args) throws Exception {
		Mail mail = new Mail();
		mail.setFrom("fitness.studio@mail.ru");
		mail.setTo("matrikary@gmail.com");
		mail.setSubject("Sending Simple Email with JavaMailSender Example");
		mail.setContent("This tutorial demonstrates how to send a simple email using Spring Framework.");

		emailService.sendSimpleMessage(mail);
	}*/
}
