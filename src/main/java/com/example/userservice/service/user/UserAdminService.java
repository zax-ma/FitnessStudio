package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.api.IUserAdminService;
import com.example.userservice.utils.convertors.UserAdminDtoToEntityConvertor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserAdminService implements IUserAdminService {

    private IUserRepository userRepository;
    private UserAdminDtoToEntityConvertor convertor;

    public UserAdminService(IUserRepository userRepository, UserAdminDtoToEntityConvertor convertor) {
        this.userRepository = userRepository;
        this.convertor = convertor;
    }

    @Override
    public void createUser(UserAdminDTO userAdminDto) {
        if (!userRepository.existsByMail(userAdminDto.getMail())) {
            //  проверка на валидность и существование пользователы
            UserEntity newUser = this.convertor.convert(userAdminDto);
            assert newUser != null;
            this.userRepository.save(newUser);
        } else {
            throw
                    new NullPointerException();
        }
    }

    @Override
    public Page<UserDTO> getUserPage(Pageable page, int size) {
        return null;
    }

    @Override
    public UserDTO getUserInfo(UUID uuid) {
        return null;
    }

    @Override
    public UserDTO updateUser(UUID uuid, LocalDateTime dt_update, UserAdminDTO user) {
        return null;
    }


}
