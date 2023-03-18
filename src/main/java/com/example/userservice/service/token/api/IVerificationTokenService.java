package com.example.userservice.service.token.api;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationTokenEntity;

import java.util.Optional;

public interface IVerificationTokenService {

    void createToken(UserEntity user);

    Optional<VerificationTokenEntity> getToken(String token);
}
