package com.example.userservice.service.api;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationTokenEntity;
import com.example.userservice.dto.UserRegistrationDTO;
import org.apache.catalina.User;

import java.util.UUID;

public interface IUserRegistrationService {

    void registration(UserEntity userEntity);


}
