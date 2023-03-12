package com.example.userservice.utils.convertors;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoToEntityConverter implements Converter<UserRegistrationDTO, UserEntity> {

    @Override
    public UserEntity convert(UserRegistrationDTO source) {
        AuxFieldsDTO auxFieldsDTO = new AuxFieldsDTO();
        return new UserEntity(
                auxFieldsDTO.getUuid(),
                source.getMail(),
                source.getFio(),
                source.getPassword(),
                UserRole.USER,
                UserStatus.WAITING_ACTIVATION,
                auxFieldsDTO.getDt_create(),
                auxFieldsDTO.getDt_update()
        );
    }
}
