package com.example.userservice.web.convertor;

import com.example.userservice.dto.*;
import com.example.userservice.utils.convertors.UserRegistrationDtoToEntityConverter;
import org.junit.jupiter.api.Test;

public class UserDtoToEntityTest {

    @Test
        public void testConvertorUser() throws Exception {
        UserRegistrationDtoToEntityConverter convertor = new UserRegistrationDtoToEntityConverter();

        AuxFieldsDTO supplFields = new AuxFieldsDTO();

        UserRegistrationDTO user = new UserRegistrationDTO("aaa@aaa.aa", "aaa", "bbb");

    //    UserDTO createdUser = new UserDTO(supplFields, user);

        convertor.convert(user);
       System.out.println(convertor.convert(user));
    //    Assertions.assertEquals("aaa", convertor.convert(createdUser).toString());

    }
}
