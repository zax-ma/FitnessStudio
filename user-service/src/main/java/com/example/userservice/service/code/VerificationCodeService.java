package com.example.userservice.service.code;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationCodeEntity;
import com.example.userservice.dao.repo.IVerificationCodeRepository;
import com.example.userservice.service.email.api.IEmailVerificationService;
import com.example.userservice.service.code.api.IVerificationCodeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
@Service
public class VerificationCodeService implements IVerificationCodeService {

    IVerificationCodeRepository repository;

    IEmailVerificationService sender;

    public VerificationCodeService(IVerificationCodeRepository repository, IEmailVerificationService sender) {
        this.repository = repository;
        this.sender = sender;
    }

    @Override
    public void createCode(UserEntity newUser) {
            String token = UUID.randomUUID().toString();
            VerificationCodeEntity confirmationToken = new VerificationCodeEntity(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(60),
                    newUser);
            repository.save(confirmationToken);
            sender.sendVerificationEmail(newUser.getMail(), token);
    }

    public VerificationCodeEntity getCode(String code) {
        return repository.findByCode(code);
    }



}

