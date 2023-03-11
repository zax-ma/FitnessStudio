package com.example.userservice.web.convertor;

import com.example.userservice.dto.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserDtoToEntityTest {

    @Test
        public void testConvertorUser() throws Exception {
        UserDtoToEntity convertor = new UserDtoToEntity();

        AuxFieldsDTO supplFields = new AuxFieldsDTO();

        UserRegistrationDTO user = new UserRegistrationDTO("aaa@aaa.aa", "aaa", "bbb");

        UserDTO createdUser = new UserDTO(supplFields, user);

        convertor.convert(createdUser);
   //     System.out.println(convertor.convert(createdUser).toString());
    //    Assertions.assertEquals("aaa", convertor.convert(createdUser).toString());

    }
}
