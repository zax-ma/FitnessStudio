package com.example.userservice.dto;

import com.example.userservice.utils.validation.annotation.EmailPattern;
import com.example.userservice.utils.validation.annotation.NotEmptyNorBlank;

public class LoginDTO {
    @NotEmptyNorBlank
    private String mail;
    @NotEmptyNorBlank
    private String password;

    public LoginDTO(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
