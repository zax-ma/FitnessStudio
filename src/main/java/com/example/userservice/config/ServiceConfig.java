package com.example.userservice.config;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.api.IUserAdminService;
import com.example.userservice.service.user.UserAdminService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ServiceConfig {

    public IUserAdminService userAdminService(IUserRepository repository,
                                              Converter<UserAdminDTO, UserEntity> toEntityConverter,
                                              Converter<UserEntity, UserDTO> toDTOConverter,
                                              PasswordEncoder passwordEncoder){

        return new UserAdminService(repository, toEntityConverter, toDTOConverter, passwordEncoder);
    }
}

