package com.example.userservice.service.email;

import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dao.repo.IVerificationCodeRepository;
import com.example.userservice.service.email.api.IEmailVerificationService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class EmailVerificationSendingService implements IEmailVerificationService {

    private final Logger LOGGER = LoggerFactory.getLogger(EmailVerificationSendingService.class);
    private final JavaMailSender javaMailSender;


    public EmailVerificationSendingService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;

    }

    @Override
    @Async
    public void sendVerificationEmail(String to, String mail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setText(mail, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("fitness.studio@mail.ru");

            javaMailSender.send(message);
        } catch (MessagingException e) {
            LOGGER.error("Failed to send e-mail", e);
            throw new IllegalStateException("Failed to send e-mail", e);
        }

    }
}
