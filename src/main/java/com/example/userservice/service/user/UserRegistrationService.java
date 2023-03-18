package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationTokenEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dao.repo.IVerificationTokenRepository;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.service.email.api.IEmailVerificationService;
import com.example.userservice.service.api.IUserRegistrationService;
import com.example.userservice.service.token.api.IVerificationTokenService;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import org.apache.catalina.User;
import org.springframework.core.convert.converter.Converter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserRegistrationService implements IUserRegistrationService {

    IUserRepository repository;
    Converter<UserRegistrationDTO, UserEntity> toEntityConverter;
    Converter<UserEntity, UserDTO> toDTOConverter;
    PasswordEncoder passwordEncoder;
    IVerificationTokenService tokenService;
    IEmailVerificationService emailVerificationService;

    public UserRegistrationService(IUserRepository repository,
                                   Converter<UserRegistrationDTO, UserEntity> toEntityConverter,
                                   Converter<UserEntity, UserDTO> toDTOConverter,
                                   PasswordEncoder passwordEncoder,
                                   IEmailVerificationService emailVerificationService,
                                   IVerificationTokenService tokenService) {
        this.repository = repository;
        this.toEntityConverter = toEntityConverter;
        this.toDTOConverter = toDTOConverter;
        this.passwordEncoder = passwordEncoder;
        this.emailVerificationService = emailVerificationService;
        this.tokenService = tokenService;
    }

    @Override
    public void registration(UserEntity newUser) {
        if (!repository.existsByMail(newUser.getMail())) {
            String encodedPassword = passwordEncoder.encode(newUser.getPassword());
            newUser.setPassword(encodedPassword);
            this.repository.save(newUser);

            String token = UUID.randomUUID().toString();
            VerificationTokenEntity confirmationToken = new VerificationTokenEntity(
                    token,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusMinutes(15),
                    newUser);
            tokenService.createToken(confirmationToken);
        } else {
            throw
                    new SingleErrorResponse("User with this email is already registered");
        }
    }

}
