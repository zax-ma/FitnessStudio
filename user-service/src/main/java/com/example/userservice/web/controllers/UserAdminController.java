package com.example.userservice.web.controllers;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.PageDTO;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.user.api.IUserAdminService;
import com.example.userservice.utils.validation.annotation.ValidParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
public class UserAdminController {

private static final Logger LOGGER = LoggerFactory.getLogger(UserAdminController.class);
    private final IUserAdminService userAdminService;
    private final Converter<UserAdminDTO, UserEntity> toEntityConverter;

    public UserAdminController(IUserAdminService userAdminService, Converter<UserAdminDTO, UserEntity> toEntityConverter) {
        this.userAdminService = userAdminService;
        this.toEntityConverter = toEntityConverter;
    }

    @ValidParams
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody UserAdminDTO userCreationAdminDto){
        UserEntity newUser = this.toEntityConverter.convert(userCreationAdminDto);
        userAdminService.createUser(newUser);
        return ResponseEntity
                .status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<PageDTO> getUserPage(@PageableDefault(page = 0, size = 20) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userAdminService.getUserPage(pageable));
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDTO> getUserInfo(@PathVariable("uuid") UUID uuid) throws JsonProcessingException {
        return ResponseEntity
                .ok(this.userAdminService.getUserInfo(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable("uuid") UUID id,
            @PathVariable("dt_update") Timestamp dt_update,
            @RequestBody UserAdminDTO user) throws JsonProcessingException {
        userAdminService.updateUser(id, dt_update, user);
        return ResponseEntity
                .ok(this.userAdminService.getUserInfo(id));
    }

}
