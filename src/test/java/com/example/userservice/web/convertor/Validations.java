package com.example.userservice.web.convertor;

import com.example.userservice.dto.*;
import com.example.userservice.service.user.api.IUserAdminService;
import com.example.userservice.utils.validation.annotation.ValidParams;
import org.junit.jupiter.api.Test;

public class Validations {
    private IUserAdminService userAdminService;

    public Validations(IUserAdminService userAdminService) {
        this.userAdminService = userAdminService;
    }

    @Test
    @ValidParams
    public void testConvertorUser() throws Exception {

        UserAdminDTO user = new UserAdminDTO().new AdminBuilder()
                .setFio("admin")
                .setMail("admin@admin.com")
                .setPassword("a")
                .setRole(UserRole.ADMIN)
                .setStatus(UserStatus.ACTIVATED)
                .build();

            userAdminService.createUser(user);


    }
}
