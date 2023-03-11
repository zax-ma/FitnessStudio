package com.example.userservice.service.user;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.service.api.IUserRegistrationService;

import java.util.UUID;

public class UserRegistrationService implements IUserRegistrationService {
    @Override
    public void registration(UserRegistrationDTO userRegistrationDTO) {
        //   регистрация + проверка на валидность и существование мыла
    }

    @Override
    public void verification(String code, String mail) {

    }
}
