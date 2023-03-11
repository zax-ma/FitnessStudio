package com.example.userservice.web.convertor;

import com.example.userservice.dto.*;
import com.example.userservice.utils.convertors.UserRegistrationDtoToEntityConvertor;
import org.junit.jupiter.api.Test;

public class UserDtoToEntityTest {

    @Test
        public void testConvertorUser() throws Exception {
        UserRegistrationDtoToEntityConvertor convertor = new UserRegistrationDtoToEntityConvertor();

        AuxFieldsDTO supplFields = new AuxFieldsDTO();

        UserRegistrationDTO user = new UserRegistrationDTO("aaa@aaa.aa", "aaa", "bbb");

    //    UserDTO createdUser = new UserDTO(supplFields, user);

    //    convertor.convert(createdUser);
   //     System.out.println(convertor.convert(createdUser).toString());
    //    Assertions.assertEquals("aaa", convertor.convert(createdUser).toString());

    }
}
