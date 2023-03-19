package com.example.userservice.service.user.api;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.LoginDTO;
import com.example.userservice.dto.UserDTO;

public interface IUserAuthenticationService {

    UserDTO getMyInfo();
    String login(LoginDTO loginDto);
    UserEntity findByMail(String mail);
}
