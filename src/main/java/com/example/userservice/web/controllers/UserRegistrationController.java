package com.example.userservice.web.controllers;


import com.example.userservice.dto.UserRegistrationDTO;

import com.example.userservice.service.api.IUserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/users")
public class UserRegistrationController {

    IUserRegistrationService userRegistrationService;
   // IUserAuthenticationService userAuthenticationService;

    public UserRegistrationController(IUserRegistrationService userRegistrationService){
                                    //  IUserAuthenticationService userAuthenticationService) {
        this.userRegistrationService = userRegistrationService;
   //     this.userAuthenticationService = userAuthenticationService;
    }

    @PostMapping("/registration")
    public ResponseEntity<?> create(@RequestBody UserRegistrationDTO userRegistrationDTO){
        userRegistrationService.registration(userRegistrationDTO);
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
  //  @GetMapping("me")
 //       public ResponseEntity<UserDTO> myInfo(){
//            return ResponseEntity.ok(this.userAuthenticationService.getMyInfo());
 //       }

   //     @PostMapping("/login")




}
