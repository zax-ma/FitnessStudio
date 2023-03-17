package com.example.userservice.web.controllers;

import com.example.userservice.dto.PageDTO;
import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.api.IUserAdminService;
import com.example.userservice.utils.validation.annotation.ValidParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/users")
public class UserAdminController {

private static final Logger LOGGER = LoggerFactory.getLogger(UserAdminController.class);
    private IUserAdminService userAdminService;

    public UserAdminController(IUserAdminService userAdminService) {
        this.userAdminService = userAdminService;
    }
    @ValidParams
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody UserAdminDTO userCreationAdminDto){
        userAdminService.createUser(userCreationAdminDto);
        LOGGER.info("hu");
        return ResponseEntity
                .status(HttpStatus.CREATED).build();

    }

    @RequestMapping(method = RequestMethod.GET)
    public PageDTO<UserDTO> getUserPage(int page, int size){
        return this.userAdminService.getUserPage(page, size);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserDTO> getUserInfo(@PathVariable("uuid") UUID uuid) throws JsonProcessingException {
        return ResponseEntity
                .ok(this.userAdminService.getUserInfo(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable("uuid") UUID uuid,
            @PathVariable("dt_update") Timestamp dt_update,
            @RequestBody UserAdminDTO user) throws JsonProcessingException {
        userAdminService.updateUser(uuid, dt_update, user);
        return ResponseEntity
                .ok(this.userAdminService.getUserInfo(uuid));
    }

}
