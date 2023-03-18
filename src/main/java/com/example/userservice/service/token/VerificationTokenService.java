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
    public void createToken(VerificationTokenEntity token) {
        repository.save(token);
    }


/*    public void createToken(UserEntity newUser) {
            String token = UUID.randomUUID().toString();
            VerificationTokenEntity confirmationToken = new VerificationTokenEntity(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(15),
                    newUser);
            createToken(confirmationToken);
    }*/


}

