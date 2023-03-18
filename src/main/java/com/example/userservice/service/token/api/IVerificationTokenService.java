package com.example.userservice.service.token.api;

import com.example.userservice.dao.entity.VerificationTokenEntity;

public interface IVerificationTokenService {

    void createToken(VerificationTokenEntity token);
}
