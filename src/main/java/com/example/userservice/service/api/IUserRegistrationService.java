package com.example.userservice.service.api;


import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;

import java.util.UUID;

public interface IUserRegistrationService {

    void registration(UserRegistrationDTO userRegistrationDTO);

    void verification(String code, String mail);
}
