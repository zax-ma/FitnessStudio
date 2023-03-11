package com.example.userservice.dao.entity;

import com.example.userservice.dto.UserRole;
import com.example.userservice.dto.UserStatus;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "app", name = "users")
public class UserEntity {
    @Id
    @Column(name = "id")
 //   @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    @Column(name = "mail")

    private String mail;
    @Column(name = "fio")

    private String fio;
    /*    @JoinColumn(name = "role", nullable = false)
        @NotNull
        @NotBlank
        @ManyToOne
        @Enumerated(EnumType.STRING)*/
    @Column(name = "role")
    private UserRole role;
    /*    @JoinColumn(name = "status", nullable = false)
        @NotNull
        @NotBlank
        @ManyToOne
        @Enumerated(EnumType.STRING)*/
    @Column(name = "status")
    private UserStatus status;
    @Column(name = "password")
    private String password;
    @Column(name = "dt_create")
    private LocalDateTime dt_create;

    @Column(name = "dt_update")
    private LocalDateTime dt_update;


    public UserEntity() {
    }

    public UserEntity(UUID uuid, String mail, String fio, String password, UserRole role, UserStatus status, LocalDateTime dt_create, LocalDateTime dt_update) {
        this.uuid = uuid;
        this.mail = mail;
        this.fio = fio;
        this.password = password;
        this.role = role;
        this.status = status;
        this.dt_create = dt_create;
        this.dt_update = dt_update;
    }

    public UserEntity(UUID uuid, String mail, String password, UserRole role, UserStatus status, LocalDateTime dt_create, LocalDateTime dt_update) {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public LocalDateTime getDt_create() {
        return dt_create;
    }

    public void setDt_create(LocalDateTime dt_create) {
        this.dt_create = dt_create;
    }

    public LocalDateTime getDt_update() {
        return dt_update;
    }

    public void setDt_update(LocalDateTime dt_update) {
        this.dt_update = dt_update;
    }
}
