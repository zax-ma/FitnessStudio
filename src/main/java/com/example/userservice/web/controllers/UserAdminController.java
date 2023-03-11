package com.example.userservice.web.controllers;

import com.example.userservice.dto.UserAdminDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.service.api.IUserAdminService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserAdminController {

    private IUserAdminService userAdminService;

    public UserAdminController(IUserAdminService userAdminService) {
        this.userAdminService = userAdminService;
    }

    @RequestMapping(method = RequestMethod.POST)
    protected ResponseEntity<?> create( @RequestBody UserAdminDTO userCreationAdminDto){
        userAdminService.createUser(userCreationAdminDto);
        return ResponseEntity
                .status(HttpStatus.CREATED).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    protected Page<UserDTO> getUserPage(Pageable page, int size){
        return this.userAdminService.getUserPage(page, size);
    }

    @GetMapping("/{uuid}")
    protected ResponseEntity<UserDTO> getUserInfo(UUID uuid){
        return ResponseEntity
                .ok(this.userAdminService.getUserInfo(uuid));
    }

    @PutMapping("/{uuid}/dt_update/{ft_update}")
    protected ResponseEntity<UserDTO> updateUser(UUID uuid, LocalDateTime dt_update,
                                                  @RequestBody UserAdminDTO user){
        return ResponseEntity
                .ok(this.userAdminService.updateUser(uuid, dt_update, user));
    }

}
