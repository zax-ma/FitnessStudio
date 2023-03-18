package com.example.userservice.utils.convertors;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.EUserRole;
import com.example.userservice.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;

public class RoleConverter implements Converter<UserEntity, EUserRole> {
    @Override
    public EUserRole convert(UserEntity source) {
        StringBuffer sb = new StringBuffer();
        sb.append("ROLE_");
        sb.append(source.getRole());
        return new EUserRole(sb.toString());

    }
}
