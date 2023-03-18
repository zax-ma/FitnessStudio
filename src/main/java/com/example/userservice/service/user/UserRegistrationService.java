package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationTokenEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dao.repo.IVerificationTokenRepository;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.service.api.IUserRegistrationService;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import org.springframework.core.convert.converter.Converter;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService implements IUserRegistrationService {

    IUserRepository repository;
    Converter<UserRegistrationDTO, UserEntity> toEntityConverter;
    Converter<UserEntity, UserDTO> toDTOConverter;
    PasswordEncoder passwordEncoder;
    IVerificationTokenRepository tokenRepository;


    public UserRegistrationService(IUserRepository repository,
                                   Converter<UserRegistrationDTO, UserEntity> toEntityConverter,
                                   Converter<UserEntity, UserDTO> toDTOConverter,
                                   PasswordEncoder passwordEncoder,
                                   IVerificationTokenRepository tokenRepository) {
        this.repository = repository;
        this.toEntityConverter = toEntityConverter;
        this.toDTOConverter = toDTOConverter;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void registration(UserEntity newUser) {
        if (!repository.existsByMail(newUser.getMail())) {
            String encodedPassword = passwordEncoder.encode(newUser.getPassword());
            newUser.setPassword(encodedPassword);
            this.repository.save(newUser);
        } else {
            throw
                    new SingleErrorResponse("User with this email is already registered");
        }
    }

    @Override
    public void verification(String code, String mail) {

    }

    @Override
    public void createVerificationToken(String token, UserEntity userEntity) {
        VerificationTokenEntity myToken = new VerificationTokenEntity(token, userEntity);
        tokenRepository.save(myToken);

    }

    @Override
    public VerificationTokenEntity getVerificationTokenEntity(String VerificationTokenEntity) {
        return null;
    }

    @Override
    public void sendRegistrationConfirmationEmail(UserEntity userEntity) {

    }
}
