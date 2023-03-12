package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserRegistrationDTO;
import com.example.userservice.service.api.IUserRegistrationService;
import com.example.userservice.utils.convertors.UserRegistrationDtoToEntityConverter;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import org.springframework.core.convert.converter.Converter;

import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService implements IUserRegistrationService {

    IUserRepository repository;
    Converter<UserRegistrationDTO, UserEntity> toEntityConverter;
    Converter<UserEntity, UserDTO> toDTOConverter;
  //  PasswordEncoder passwordEncoder;

    public UserRegistrationService(IUserRepository repository,
                                   Converter<UserRegistrationDTO, UserEntity> toEntityConverter,
                                   Converter<UserEntity, UserDTO> toDTOConverter) {
        this.repository = repository;
        this.toEntityConverter = toEntityConverter;
        this.toDTOConverter = toDTOConverter;

    }

/*    public UserRegistrationService(IUserRepository repository,
                                   Converter<UserRegistrationDTO, UserEntity> toEntityConverter,
                                   Converter<UserEntity, UserDTO> toDTOConverter,
                                   PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.toEntityConverter = toEntityConverter;
        this.toDTOConverter = toDTOConverter;
        this.passwordEncoder = passwordEncoder;
    }*/

    @Override
    public void registration(UserRegistrationDTO userRegistrationDTO) {
        //   регистрация + проверка на валидность и существование мыла
        if (!repository.existsByMail(userRegistrationDTO.getMail())) {
            UserEntity newUser = this.toEntityConverter.convert(userRegistrationDTO);
            assert newUser != null;
            this.repository.save(newUser);
        } else {
            throw
                    new SingleErrorResponse("User with this email is already registered");
        }
    }

    @Override
    public void verification(String code, String mail) {

    }
}
