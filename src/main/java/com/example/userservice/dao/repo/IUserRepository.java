package com.example.userservice.dao.repo;

import com.example.userservice.dao.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Transactional
public interface IUserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByMail(String mail);

    boolean existsByMail(String mail);
}
