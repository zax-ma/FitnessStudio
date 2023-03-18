package com.example.userservice.dao.repo;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional
@Repository
public interface IUserRepository extends JpaRepository<UserEntity, UUID> {

    UserEntity findByMail(String mail);

    boolean existsByMail(String mail);


    @Modifying
    @Transactional
    @Query(value = "update app.users c set c.status=:status where c.mail=:mail", nativeQuery=true)
    void saveStatusByMail(UserStatus status, String mail);

}
