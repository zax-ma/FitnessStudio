package com.example.userservice.utils.convertors;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class EntityToDtoConverter implements Converter<UserEntity, UserDTO> {
    @Override
    public UserDTO convert(UserEntity source) {

            return new UserDTO(
                    source.getUuid(),
                    source.getDt_create(),
                    source.getDt_update(),
                    source.getStatus(),
                    source.getRole(),
                    source.getFio(),
                    source.getMail(),
                    source.getPassword()
                    );
        }

}
