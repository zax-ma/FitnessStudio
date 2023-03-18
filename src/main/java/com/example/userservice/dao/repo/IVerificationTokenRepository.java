
package com.example.userservice.dao.repo;

import com.example.userservice.dao.entity.VerificationTokenEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface IVerificationTokenRepository extends JpaRepository<VerificationTokenEntity, Long> {

  //  VerificationTokenEntity findByMail(String mail);
    VerificationTokenEntity findByToken(final String token);
    Long removeByToken(String token);

}

