package com.example.userservice.config;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.utils.convertors.EntityToDtoConverter;
import com.example.userservice.utils.convertors.UserAdminDtoToEntityConverter;
import com.example.userservice.utils.convertors.UserRegistrationDtoToEntityConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;

public class ConverterConfig {

    @Bean
    public Converter<UserAdminDTO, UserEntity> userAdminDTOUserEntityConverter(){
        return new UserAdminDtoToEntityConverter();
    }

    @Bean
    public Converter<UserRegistrationDTO, UserEntity> userRegistrationDTOUserEntityConverter(){
        return new UserRegistrationDtoToEntityConverter();
    }

    @Bean
    public Converter<UserEntity, UserDTO> userEntityUserDTOConverter(){
        return new EntityToDtoConverter();
    }
}
