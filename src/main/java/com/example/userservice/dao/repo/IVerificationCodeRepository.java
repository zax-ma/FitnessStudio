
package com.example.userservice.dao.repo;

import com.example.userservice.dao.entity.VerificationCodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVerificationCodeRepository extends JpaRepository<VerificationCodeEntity, Long> {
    VerificationCodeEntity findByCode(String code);


}

