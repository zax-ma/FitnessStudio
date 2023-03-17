package com.example.userservice.service.api;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.UserRegistrationDTO;

import java.util.UUID;

public interface IUserRegistrationService {

    void registration(UserEntity userEntity);

    void verification(String code, String mail);
}
