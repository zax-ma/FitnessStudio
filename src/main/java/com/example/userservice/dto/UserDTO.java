package com.example.userservice.dto;


import java.time.LocalDateTime;

public class UserDTO {
    private AuxFieldsDTO auxFieldsDTO;
    private UserStatus status;
    private UserRole role;
    private String fio;
    private String mail;
    private String password;
    private LocalDateTime dt_create;
    private LocalDateTime dt_update;
}
