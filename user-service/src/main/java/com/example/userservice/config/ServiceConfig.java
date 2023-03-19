package com.example.userservice.config;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dao.repo.IVerificationCodeRepository;
import com.example.userservice.dto.EUserRole;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.security.JwtUserDetailsService;
import com.example.userservice.service.email.api.IEmailVerificationService;
import com.example.userservice.service.user.UserAuthenticationService;
import com.example.userservice.service.user.api.IUserAdminService;
import com.example.userservice.service.user.api.IUserAuthenticationService;
import com.example.userservice.service.user.api.IUserRegistrationService;
import com.example.userservice.service.code.VerificationCodeService;
import com.example.userservice.service.code.api.IVerificationCodeService;
import com.example.userservice.service.user.UserAdminService;
import com.example.userservice.service.user.UserRegistrationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class ServiceConfig {
    public IUserAdminService userAdminService(IUserRepository repository,
                                              Converter<UserAdminDTO, UserEntity> toEntityConverter,
                                              Converter<UserEntity, UserDTO> toDTOConverter,
                                              PasswordEncoder passwordEncoder
                                              ){

        return new UserAdminService(repository, toEntityConverter, toDTOConverter, passwordEncoder);
    }

    public IVerificationCodeService verificationTokenService(IVerificationCodeRepository repository, IEmailVerificationService emailVerificationService){
        return new VerificationCodeService(repository, emailVerificationService);
    }

    public IUserRegistrationService userRegistrationService(IUserRepository repository,
                                                            Converter<UserRegistrationDTO, UserEntity> toEntityConverter,
                                                            Converter<UserEntity, UserDTO> toDTOConverter,
                                                            PasswordEncoder passwordEncoder,
                                                            IVerificationCodeService tokenService){
        return new UserRegistrationService(repository, toEntityConverter, toDTOConverter, passwordEncoder, tokenService);
    }

    public IUserAuthenticationService userAuthenticationService(IUserRepository repository,
                                                                Converter<UserEntity, UserDTO> toDtoConverter,
                                                                PasswordEncoder encoder){
        return new UserAuthenticationService(repository, toDtoConverter, encoder);
    }

    public UserDetailsService jwtUserService(IUserAuthenticationService userService,
                                             Converter<UserEntity, EUserRole> roleconverter) {
        return new JwtUserDetailsService(userService, roleconverter);
    }


}


