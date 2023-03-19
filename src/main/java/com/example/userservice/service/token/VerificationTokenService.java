package com.example.userservice.service.token;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationTokenEntity;
import com.example.userservice.dao.repo.IVerificationTokenRepository;
import com.example.userservice.service.email.api.IEmailVerificationService;
import com.example.userservice.service.token.api.IVerificationTokenService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class VerificationTokenService implements IVerificationTokenService {

    IVerificationTokenRepository repository;

    IEmailVerificationService sender;

    public VerificationTokenService(IVerificationTokenRepository repository, IEmailVerificationService sender) {
        this.repository = repository;
        this.sender = sender;
    }

    @Override
    public void createToken(UserEntity newUser) {
            String token = UUID.randomUUID().toString();
            VerificationTokenEntity confirmationToken = new VerificationTokenEntity(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(15),
                    newUser);
            repository.save(confirmationToken);
            sender.sendVerificationEmail(newUser.getMail(), token);
    }

    public VerificationTokenEntity getToken(String token) {
        return repository.findByToken(token);
    }


/*
    public int setConfirmedAt(String token) {
        return repository.updateConfirmedAt(
                token, LocalDateTime.now());
    }
*/


}

