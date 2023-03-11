package com.example.userservice.utils.convertors;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;

public class EntityToDtoConvertor implements Converter<UserEntity, UserDTO> {
    @Override
    public UserDTO convert(UserEntity source) {
        return null;
    }
}
