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

}
