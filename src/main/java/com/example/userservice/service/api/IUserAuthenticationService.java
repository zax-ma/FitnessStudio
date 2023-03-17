package com.example.userservice.service.api;

import com.example.userservice.dto.LoginDTO;
import com.example.userservice.dto.UserDTO;

public interface IUserAuthenticationService {

    UserDTO getMyInfo(); //передача токена для получения информации из дао
    LoginDTO login();
}
