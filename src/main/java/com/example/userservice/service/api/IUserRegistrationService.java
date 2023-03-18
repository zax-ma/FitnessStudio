package com.example.userservice.service.api;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationTokenEntity;
import com.example.userservice.dto.UserRegistrationDTO;
import org.apache.catalina.User;

import java.util.UUID;

public interface IUserRegistrationService {

    void registration(UserEntity userEntity);

    void verification(String code, String mail);

    void createVerificationToken(String token, UserEntity userEntity);

    VerificationTokenEntity getVerificationTokenEntity(String VerificationTokenEntity);

    void sendRegistrationConfirmationEmail(UserEntity userEntity);
}
