package com.example.userservice.service.api;

import com.example.userservice.dto.PageDTO;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public interface IUserAdminService {

    void createUser(UserAdminDTO userCreationAdminDto);
    PageDTO<UserDTO> getUserPage(int page, int size);

    UserDTO getUserInfo(UUID uuid);

   void updateUser(UUID uuid, Timestamp dt_update, UserAdminDTO user);

}
