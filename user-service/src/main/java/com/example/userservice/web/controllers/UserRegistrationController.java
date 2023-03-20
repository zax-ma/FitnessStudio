package com.example.userservice.web.controllers;

import com.example.userservice.security.AuthenticationResponse;
import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.service.user.api.IUserRegistrationService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/users")
public class UserRegistrationController {

    IUserRegistrationService userRegistrationService;
    Converter<UserRegistrationDTO, UserEntity> toEntityConverter;


    public UserRegistrationController(IUserRegistrationService userRegistrationService,
                                      Converter<UserRegistrationDTO, UserEntity> toEntityConverter
                                      ) {
        this.userRegistrationService = userRegistrationService;
        this.toEntityConverter = toEntityConverter;
    }

    @PostMapping("/registration")
    public ResponseEntity<AuthenticationResponse> create(@RequestBody UserRegistrationDTO newUserDTO){
        UserEntity newUser = this.toEntityConverter.convert(newUserDTO);
        userRegistrationService.registration(newUser);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();

    }

    @GetMapping("/verification")
    public ResponseEntity<String> verifyToken(@RequestParam("code") String code,
                                             @RequestParam("mail") String mail) {
        userRegistrationService.verification(code, mail);
        return ResponseEntity.ok("Mail was confirmed");
    }

}
