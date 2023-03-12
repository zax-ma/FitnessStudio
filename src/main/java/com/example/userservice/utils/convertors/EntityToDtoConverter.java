package com.example.userservice.utils.convertors;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.*;
import org.aspectj.weaver.Utils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

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
