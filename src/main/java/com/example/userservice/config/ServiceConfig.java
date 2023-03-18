package com.example.userservice.config;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dao.repo.IVerificationTokenRepository;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.service.api.IEmailVerificationService;
import com.example.userservice.service.api.IUserAdminService;
import com.example.userservice.service.api.IUserAuthenticationService;
import com.example.userservice.service.api.IUserRegistrationService;
import com.example.userservice.service.user.UserAdminService;
import com.example.userservice.service.user.UserRegistrationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class ServiceConfig {
    public IUserAdminService userAdminService(IUserRepository repository,
                                              Converter<UserAdminDTO, UserEntity> toEntityConverter,
                                              Converter<UserEntity, UserDTO> toDTOConverter
                                              ){

        return new UserAdminService(repository, toEntityConverter, toDTOConverter);
    }


/*    public IUserAdminService userAdminService(IUserRepository repository,
                                              Converter<UserAdminDTO, UserEntity> toEntityConverter,
                                              Converter<UserEntity, UserDTO> toDTOConverter,
                                             PasswordEncoder passwordEncoder){

        return new UserAdminService(repository, toEntityConverter, toDTOConverter, passwordEncoder);
    }
    */

    public IUserRegistrationService userRegistrationService(IUserRepository repository,
                                                            Converter<UserRegistrationDTO, UserEntity> toEntityConverter,
                                                            Converter<UserEntity, UserDTO> toDTOConverter,
                                                            PasswordEncoder passwordEncoder,
                                                            IVerificationTokenRepository tokenRepository){
        return new UserRegistrationService(repository, toEntityConverter, toDTOConverter, passwordEncoder, tokenRepository);
    }

    public IEmailVerificationService emailVerificationService(){
        return null;
    }
    public IUserAuthenticationService userAuthenticationService(){
        return null;
    }



}


