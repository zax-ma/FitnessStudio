package com.example.userservice.web.convertor;

import com.example.userservice.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

public class AdminDtotoEntity {
    @Test
    public void testConvertorUser() throws Exception {
        UserDtoToEntity convertor = new UserDtoToEntity();
        AuxFieldsDTO supplFields = new AuxFieldsDTO();


        UserAdminDTO user = new UserAdminDTO().new AdminBuilder()
                .setFio("admin")
                .setMail("admin@admin.com")
                .setPassword("admin")
                .setRole(UserRole.ADMIN)
                .setStatus(UserStatus.ACTIVATED)
                .build();

        UserDTO createdUser = new UserDTO(supplFields, user);
        convertor.convert(createdUser);

    }
}
