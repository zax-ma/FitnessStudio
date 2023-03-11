package com.example.userservice.service.user;

import com.example.userservice.dao.api.IUserRepository;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.api.IUserAdminService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserAdminService implements IUserAdminService {

    private IUserRepository userRepository;


    @Override
    public void createUser(UserAdminDTO userCreationAdminDto) {
      //  проверка на валидность и существование пользователы
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
