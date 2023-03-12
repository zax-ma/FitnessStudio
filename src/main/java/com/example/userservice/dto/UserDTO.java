package com.example.userservice.dto;


import com.example.userservice.dao.entity.UserEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserDTO {
    private AuxFieldsDTO auxFieldsDTO;
    private UserStatus status;
    private UserRole role;
    private String fio;
    private String mail;
    private String password;
    private LocalDateTime dt_create;
    private LocalDateTime dt_update;

    public UserDTO() {
    }

    public AuxFieldsDTO getAuxFieldsDTO() {
        return auxFieldsDTO;
    }

    public UserStatus getStatus() {
        return status;
    }

    public UserRole getRole() {
        return role;
    }

    public String getFio() {
        return fio;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public LocalDateTime getDt_create() {
        return dt_create;
    }

    public LocalDateTime getDt_update() {
        return dt_update;
    }

    public class UserDtoBuilder {

        private UUID uuid;
        private LocalDateTime dt_create;
        private LocalDateTime dt_update;
        private UserStatus status;
        private UserRole role;
        private String fio;
        private String mail;
        private String password;


        public UserDtoBuilder() {
        }

        public UserDtoBuilder create() {
            return new UserDtoBuilder();
        }


        public UserDtoBuilder setFio(String fio) {
            this.fio = fio;
            return this;
        }

        public UserDtoBuilder setMail(String mail) {
            this.mail = mail;
            return this;
        }

        public UserDtoBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public static UserDTO build() {
            return new UserDTO();
        }
    }

    public static UserRegistrationDTO fromEntity(UserEntity entity){
        return UserRegistrationDTO.UserRegistrationBuilder
                .create()
                .setFio(entity.getFio())
                .setMail(entity.getMail())
                .setPassword(entity.getPassword()).build();

    }
}
