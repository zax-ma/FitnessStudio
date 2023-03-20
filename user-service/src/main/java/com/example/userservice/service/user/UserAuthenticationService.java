package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.LoginDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.security.UserHolder;
import com.example.userservice.security.jwt.JwtTokenProvider;
import com.example.userservice.service.user.api.IUserAuthenticationService;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import jakarta.validation.ValidationException;
import org.apache.catalina.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService implements IUserAuthenticationService {

    private IUserRepository repository;
    private Converter<UserEntity, UserDTO> toDtoConverter;
    private PasswordEncoder encoder;

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider jwtTokenProvider;

    private UserHolder userHolder;

    public UserAuthenticationService(IUserRepository repository,
                                     Converter<UserEntity, UserDTO> toDtoConverter,
                                     PasswordEncoder encoder,
                                     JwtTokenProvider jwtTokenProvider,
                                     UserHolder userHolder) {
        this.repository = repository;
        this.toDtoConverter = toDtoConverter;
        this.encoder = encoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userHolder = userHolder;
    }

    @Override
    public UserDTO getMyInfo() {

       UserEntity userInfo = (UserEntity) this.userHolder.getAuthentication().getPrincipal();
        return this.toDtoConverter.convert(userInfo);
    }

    @Override
    public String login(LoginDTO loginDTO) {
        UserEntity user = repository.findByMail(loginDTO.getMail());
        if(user != null){
            if(encoder.matches(loginDTO.getPassword(), user.getPassword())){

              return  jwtTokenProvider.createToken(user);
                //jwt generation
            } throw new ValidationException("Wrong password");
        }throw new ValidationException("Wrong e-mail");
    }

    @Override
    public UserEntity findByMail(String mail) {
        UserEntity user = repository.findByMail(mail);
        if(user == null){
            throw new SingleErrorResponse("User with mail" + mail + " was not found");
        }
        return user;
    }
}
