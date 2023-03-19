package com.example.userservice.service.email.api;

public interface IEmailVerificationService {

    void sendVerificationEmail(String to, String mail);
}
