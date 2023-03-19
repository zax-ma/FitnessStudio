package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationTokenEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.dto.UserStatus;
import com.example.userservice.service.user.api.IUserRegistrationService;
import com.example.userservice.service.token.api.IVerificationTokenService;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import org.springframework.core.convert.converter.Converter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserRegistrationService implements IUserRegistrationService {

    IUserRepository repository;
    Converter<UserRegistrationDTO, UserEntity> toEntityConverter;
    Converter<UserEntity, UserDTO> toDTOConverter;
    PasswordEncoder passwordEncoder;
    IVerificationTokenService tokenService;

    public UserRegistrationService(IUserRepository repository,
                                   Converter<UserRegistrationDTO, UserEntity> toEntityConverter,
                                   Converter<UserEntity, UserDTO> toDTOConverter,
                                   PasswordEncoder passwordEncoder,
                                   IVerificationTokenService tokenService) {
        this.repository = repository;
        this.toEntityConverter = toEntityConverter;
        this.toDTOConverter = toDTOConverter;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @Override
    public void registration(UserEntity newUser) {
        if (!repository.existsByMail(newUser.getMail())) {
            String encodedPassword = passwordEncoder.encode(newUser.getPassword());
            newUser.setPassword(encodedPassword);
            this.repository.save(newUser);
            tokenService.createToken(newUser);
        } else {
            throw
                    new SingleErrorResponse("User with this email is already registered");
        }
    }

    @Override
    public void verification(String token, String mail) {
        UserEntity user = repository.findByMail(mail);
        VerificationTokenEntity code = tokenService.getToken(token);
        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        if (token.equals(code.getToken()) && mail.equals(user.getMail())
                && !time.after(Timestamp.valueOf(code.getExpiryAt()))) {
            user.setStatus(UserStatus.ACTIVATED);
            repository.save(user);
        } else throw new SingleErrorResponse("Token expired!");
    }
}


