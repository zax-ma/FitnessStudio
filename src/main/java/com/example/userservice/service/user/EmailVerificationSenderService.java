package com.example.userservice.service.user;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailVerificationSenderService {

    private JavaMailSender javaMailSender;

    public EmailVerificationSenderService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
/*    @Async
    public void setJavaMailSender(SimpleMailMessage){

}*/

}
