package com.example.userservice.web.controllers;

import com.example.userservice.security.AuthenticationResponse;
import com.example.userservice.dto.LoginDTO;
import com.example.userservice.service.user.api.IUserAuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users/login")
public class UserLoginController {

    private final IUserAuthenticationService service;
    public UserLoginController(IUserAuthenticationService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginDTO loginDto){
        return ResponseEntity.ok(service.login(loginDto));
    }
}
