package com.example.userservice.web.convertor;

import com.example.userservice.dto.*;
import com.example.userservice.service.api.IUserAdminService;
import com.example.userservice.utils.convertors.UserRegistrationDtoToEntityConverter;
import com.example.userservice.utils.validation.annotation.ValidParams;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
