package com.example.userservice.web.controllers;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.service.api.IUserAuthenticationService;
import com.example.userservice.service.api.IUserRegistrationService;
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
    public ResponseEntity<?> create(@RequestBody UserRegistrationDTO newUserDTO){
        UserEntity newUser = this.toEntityConverter.convert(newUserDTO);
        userRegistrationService.registration(newUser);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();

    }

    @GetMapping("/verification")
    public ResponseEntity<String> verifyCode(@RequestParam String code,
                                             @RequestParam String mail) {

        //TODO: implement mail verification functionality
        return ResponseEntity.ok("Mail was confirmed");
    }
/*    @GetMapping("/me")
        public ResponseEntity<UserDTO> myInfo(){
            return ResponseEntity.ok(this.userAuthenticationService.getMyInfo());
        }*/





}
