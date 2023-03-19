package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.LoginDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.user.api.IUserAuthenticationService;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService implements IUserAuthenticationService {

    IUserRepository repository;
    private Converter<UserEntity, UserDTO> toDtoConverter;

    public UserAuthenticationService(IUserRepository repository, Converter<UserEntity, UserDTO> toDtoConverter) {
        this.repository = repository;
        this.toDtoConverter = toDtoConverter;
    }

    @Override
    public UserDTO getMyInfo() {

        UserEntity userInfo = this.repository.findById(uuid)
                .orElseThrow(() -> new SingleErrorResponse("User with uuid " + uuid + " was not found"));
        return this.toDtoConverter.convert(userInfo);
        
    }

    @Override
    public void login(LoginDTO loginDTO) {
        if(repository.existsByMail(loginDTO.getMail())){

        }
    }
}
