package com.example.userservice.web.convertor;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;

public class UserDtoToEntity implements Converter<UserDTO, UserEntity> {
    @Override
    public UserEntity convert(UserDTO source) {
        return new UserEntity(
                source.getAuxFieldsDTO().getUuid(),
                source.getUserRegistrationDTO().getMail(),
                source.getUserRegistrationDTO().getFio(),
                source.getUserRegistrationDTO().getPassword(),
                source.getRole(),
                source.getStatus(),
                source.getAuxFieldsDTO().getDt_create(),
                source.getAuxFieldsDTO().getDt_update()

        );
    }
}
