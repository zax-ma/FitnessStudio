package com.example.userservice.service.email;

import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dao.repo.IVerificationTokenRepository;
import com.example.userservice.service.email.api.IEmailVerificationService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificationService implements IEmailVerificationService {

    private JavaMailSender javaMailSender;
    private IUserRepository userRepository;
    private IVerificationTokenRepository tokenRepository;

    public EmailVerificationService(JavaMailSender javaMailSender, IUserRepository userRepository, IVerificationTokenRepository tokenRepository) {
        this.javaMailSender = javaMailSender;
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void sendVerificationEmail() {

    }
}
