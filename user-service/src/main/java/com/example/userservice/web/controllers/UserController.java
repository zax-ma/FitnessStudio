package com.example.userservice.web.controllers;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.PageDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.user.api.IUserAuthenticationService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/users/me")
public class UserController {
    IUserAuthenticationService service;
    Converter<UserEntity, UserDTO> toDTOConverter;

    public UserController(IUserAuthenticationService service, Converter<UserEntity, UserDTO> toDTOConverter) {
        this.service = service;
        this.toDTOConverter = toDTOConverter;
    }
    @RequestMapping(method = RequestMethod.GET)
        public ResponseEntity<UserDTO> myInfo(){
            return ResponseEntity.ok(this.service.getMyInfo());
        }

}
