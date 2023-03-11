package com.example.userservice.dto;


import com.example.userservice.utils.validation.annotation.CharSize;
import com.example.userservice.utils.validation.annotation.EmailPattern;
import com.example.userservice.utils.validation.annotation.NotEmptyOrBlank;

public class UserRegistrationDTO {

 //   @JsonProperty("mail")
    @NotEmptyOrBlank
    @EmailPattern("^[a-zA-Z0-9_+&*-] + (?:\\\\.[a-zA-Z0-9_+&*-] + )*@(?:[a-zA-Z0-9-]+\\\\.) + [a-zA-Z]{2, 7}")
    private String mail;
 //   @JsonProperty("fio")

    @NotEmptyOrBlank
    private String fio;
//    @JsonProperty("password")

    @NotEmptyOrBlank
    @CharSize(min = "3", max = "16")
    private String password;

    public UserRegistrationDTO() {
    }

    public UserRegistrationDTO(String mail, String fio, String password) {
        this.mail = mail;
        this.fio = fio;
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
