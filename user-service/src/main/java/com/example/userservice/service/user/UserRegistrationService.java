package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.entity.VerificationCodeEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.UserStatus;
import com.example.userservice.security.AuthenticationResponse;
import com.example.userservice.security.JwtService;
import com.example.userservice.service.code.api.IVerificationCodeService;
import com.example.userservice.service.user.api.IUserRegistrationService;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import com.example.userservice.utils.exceptions.errors.MailAlreadyExistException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UserRegistrationService implements IUserRegistrationService {

    private final IUserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final IVerificationCodeService codeService;
    private final JwtService jwtService;


    public UserRegistrationService(IUserRepository repository,
                                   PasswordEncoder passwordEncoder,
                                   IVerificationCodeService codeService,
                                   JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.codeService = codeService;
        this.jwtService = jwtService;
    }

    @Override
    public AuthenticationResponse registration(UserEntity newUser) {
        if (!this.repository.existsByMail(newUser.getMail())) {
            String encodedPassword = this.passwordEncoder.encode(newUser.getPassword());

            newUser.setPassword(encodedPassword);
            this.repository.save(newUser);
            codeService.createCode(newUser);
        } else {
            throw
                    new MailAlreadyExistException("User with this email is already registered");
        }

        return new AuthenticationResponse(jwtService.generateToken(newUser));

    }

    @Override
    public void verification(String code, String mail) {
        UserEntity user = this.repository.findByMail(mail);
        VerificationCodeEntity verificationCode = this.codeService.getCode(code);
        Timestamp time = Timestamp.valueOf(LocalDateTime.now());
        if (code.equals(verificationCode.getCode()) && mail.equals(user.getMail())
                && !time.after(Timestamp.valueOf(verificationCode.getExpiryAt()))) {
            user.setStatus(UserStatus.ACTIVATED);
            this.repository.save(user);
        } else throw new SingleErrorResponse("Code expired!");
    }
}


