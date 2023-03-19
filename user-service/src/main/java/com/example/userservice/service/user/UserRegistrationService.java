package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationCodeEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.dto.UserStatus;
import com.example.userservice.service.user.api.IUserRegistrationService;
import com.example.userservice.service.code.api.IVerificationCodeService;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import org.springframework.core.convert.converter.Converter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserRegistrationService implements IUserRegistrationService {

    private IUserRepository repository;
    private PasswordEncoder passwordEncoder;
    private IVerificationCodeService tokenService;

    public UserRegistrationService(IUserRepository repository,
                                   PasswordEncoder passwordEncoder,
                                   IVerificationCodeService tokenService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public void registration(UserEntity newUser) {
        if (!repository.existsByMail(newUser.getMail())) {
            String encodedPassword = passwordEncoder.encode(newUser.getPassword());
            newUser.setPassword(encodedPassword);
            this.repository.save(newUser);
            tokenService.createCode(newUser);
        } else {
            throw
                    new SingleErrorResponse("User with this email is already registered");
        }
    }

    @Override
    public void verification(String code, String mail) {
        UserEntity user = repository.findByMail(mail);
        VerificationCodeEntity verificationCode = tokenService.getCode(code);
        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        if (code.equals(verificationCode.getCode()) && mail.equals(user.getMail())
                && !time.after(Timestamp.valueOf(verificationCode.getExpiryAt()))) {
            user.setStatus(UserStatus.ACTIVATED);
            repository.save(user);
        } else throw new SingleErrorResponse("Code expired!");
    }
}


