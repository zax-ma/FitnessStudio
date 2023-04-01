package com.example.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.UUID;

public class UserDTO {
    @JsonProperty("id")
    private UUID uuid;
    @JsonProperty("dt_create")
    private LocalDateTime dt_create;
    @JsonProperty("dt_update")
    private LocalDateTime dt_update;
    @JsonProperty("status")
    private UserStatus status;
    @JsonProperty("role")
    private UserRole role;
    @JsonProperty("fio")
    private String fio;
    @JsonProperty("mail")
    private String mail;
    @JsonProperty("password")
    private String password;


    public UserDTO(UUID uuid, LocalDateTime dt_create, LocalDateTime dt_update, UserStatus status, UserRole role, String fio, String mail, String password) {
        this.uuid = uuid;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
        this.status = status;
        this.role = role;
        this.fio = fio;
        this.mail = mail;
        this.password = password;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDt_create() {
        return dt_create;
    }

    public LocalDateTime getDt_update() {
        return dt_update;
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

}
