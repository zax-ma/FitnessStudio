package com.example.userservice.web.convertor;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.*;
import com.example.userservice.service.api.IUserAdminService;
import com.example.userservice.service.user.UserAdminService;
import com.example.userservice.utils.convertors.EntityToDtoConverter;
import com.example.userservice.utils.convertors.UserAdminDtoToEntityConverter;
import com.example.userservice.utils.convertors.UserRegistrationDtoToEntityConverter;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public class AdminDtotoEntity {

    @Test
    public void testConvertorUser() throws Exception {

        UserAdminDtoToEntityConverter convertor = new UserAdminDtoToEntityConverter();


        UserAdminDTO user = new UserAdminDTO().new AdminBuilder()
                .setFio("admin")
                .setMail("admin@admin.com")
                .setPassword("a")
                .setRole(UserRole.ADMIN)
                .setStatus(UserStatus.ACTIVATED)
                .build();


        System.out.println(convertor.convert(user));
    }
}
