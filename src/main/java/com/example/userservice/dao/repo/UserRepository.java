package com.example.userservice.dao.repo;


import com.example.userservice.dao.entity.UserEntity;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.Repository;

public class UserRepository implements Repository<UserEntity, Long> {
}
