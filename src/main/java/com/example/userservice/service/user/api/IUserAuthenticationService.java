package com.example.userservice.service.user.api;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.LoginDTO;
import com.example.userservice.dto.UserDTO;

public interface IUserAuthenticationService {

    UserDTO getMyInfo(); //передача токена для получения информации из дао
    void login(LoginDTO loginDto);
    UserEntity findByMail(String mail);
}
