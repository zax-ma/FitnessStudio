package com.example.userservice.service.user.api;

import com.example.userservice.security.AuthenticationResponse;
import com.example.userservice.dao.entity.UserEntity;

public interface IUserRegistrationService {

    AuthenticationResponse registration(UserEntity userEntity);

    void verification(String token, String mail);


}
