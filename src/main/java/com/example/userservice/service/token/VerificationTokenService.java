package com.example.userservice.service.token;

import com.example.userservice.dao.entity.VerificationTokenEntity;
import com.example.userservice.dao.repo.IVerificationTokenRepository;
import com.example.userservice.service.token.api.IVerificationTokenService;
import org.apache.tomcat.util.codec.binary.Base64;

import java.time.LocalDateTime;
import java.util.UUID;

public class VerificationTokenService implements IVerificationTokenService {

    IVerificationTokenRepository repository;

    public VerificationTokenService(IVerificationTokenRepository repository) {
        this.repository = repository;
    }

    @Override
    public VerificationTokenEntity create() {
        return null;
    }

/*    @Override
    public VerificationTokenEntity create() {
        String tokenValue = UUID.randomUUID().toString();
        VerificationTokenEntity token = new VerificationTokenEntity();
        token.setToken(tokenValue);
        token.setExpiryDate(LocalDateTime.now().plus(getTokenValidityInSeconds()));
        repository.save(token);

        return token;
    }*/
}
