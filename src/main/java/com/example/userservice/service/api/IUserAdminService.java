package com.example.userservice.service.api;

import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserAdminService {

    void createUser(UserAdminDTO userCreationAdminDto);
    Page<UserDTO> getUserPage(Pageable page, int size);

    UserDTO getUserInfo(UUID uuid);

    UserDTO updateUser(UUID uuid, LocalDateTime dt_update, UserAdminDTO user);

}
