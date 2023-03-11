package com.example.userservice.web.convertor;

import com.example.userservice.dto.*;
import com.example.userservice.utils.convertors.UserRegistrationDtoToEntityConvertor;
import org.junit.jupiter.api.Test;

public class AdminDtotoEntity {
    @Test
    public void testConvertorUser() throws Exception {
        UserRegistrationDtoToEntityConvertor convertor = new UserRegistrationDtoToEntityConvertor();
        AuxFieldsDTO supplFields = new AuxFieldsDTO();


        UserAdminDTO user = new UserAdminDTO().new AdminBuilder()
                .setFio("admin")
                .setMail("admin@admin.com")
                .setPassword("admin")
                .setRole(UserRole.ADMIN)
                .setStatus(UserStatus.ACTIVATED)
                .build();

   //     UserDTO createdUser = new UserDTO(supplFields, user);
   //     convertor.convert(createdUser);

    }
}
