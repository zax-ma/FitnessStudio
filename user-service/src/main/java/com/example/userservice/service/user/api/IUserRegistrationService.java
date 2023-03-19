package com.example.userservice.service.user.api;

import com.example.userservice.dao.entity.UserEntity;

public interface IUserRegistrationService {

    void registration(UserEntity userEntity);

    void verification(String token, String mail);


}
