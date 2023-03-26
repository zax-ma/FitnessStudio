package com.example.userservice.dao.repo;

import com.example.userservice.dao.entity.UserEntity;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Transactional
@Repository
public interface IUserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByMail(String mail);

    boolean existsByMail(String mail);

    Optional<UserEntity> findById(UUID id);

    @Query(value = "SELECT c FROM UserEntity c")
    Page<UserEntity> findAllPage(Pageable pageable);

}
