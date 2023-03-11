package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.service.api.IUserRegistrationService;
import com.example.userservice.utils.convertors.UserRegistrationDtoToEntityConvertor;

import java.util.UUID;

public class UserRegistrationService implements IUserRegistrationService {

    IUserRepository userRepository;

    UserRegistrationDtoToEntityConvertor convertor;

    public UserRegistrationService(IUserRepository userRepository, UserRegistrationDtoToEntityConvertor convertor) {
        this.userRepository = userRepository;
        this.convertor = convertor;
    }

    @Override
    public void registration(UserRegistrationDTO userRegistrationDTO) {
        //   регистрация + проверка на валидность и существование мыла
        if (!userRepository.existsByMail(userRegistrationDTO.getMail())) {
            UserEntity newUser = this.convertor.convert(userRegistrationDTO);
            assert newUser != null;
            this.userRepository.save(newUser);
        } else {
            throw
                    new NullPointerException();
        }
    }

    @Override
    public void verification(String code, String mail) {

    }
}
