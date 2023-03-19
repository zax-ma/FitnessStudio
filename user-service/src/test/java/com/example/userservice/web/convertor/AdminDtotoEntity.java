package com.example.userservice.web.convertor;

import com.example.userservice.dto.*;
import com.example.userservice.utils.convertors.UserAdminDtoToEntityConverter;
import org.junit.jupiter.api.Test;

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
