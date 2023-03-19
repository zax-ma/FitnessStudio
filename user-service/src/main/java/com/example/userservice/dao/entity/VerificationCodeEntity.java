
package com.example.userservice.dao.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(schema = "app", name = "codes")
public class VerificationCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiryAt;

    @ManyToOne
    @JoinColumn(nullable = false, name = "mail")
    private UserEntity user;

    public VerificationCodeEntity() {
    }

    public VerificationCodeEntity(
            String code,
            LocalDateTime createdAt,
            LocalDateTime expiryAt,
            UserEntity user
            ) {
        this.code = code;
        this.createdAt = createdAt;
        this.expiryAt = expiryAt;
        this.user = user;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiryAt() {
        return expiryAt;
    }

    public void setExpiryAt(LocalDateTime expiryAt) {
        this.expiryAt = expiryAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}

