package com.example.userservice.service.user;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dao.repo.IUserRepository;
import com.example.userservice.dto.LoginDTO;
import com.example.userservice.dto.UserDTO;
import com.example.userservice.security.AuthenticationResponse;
import com.example.userservice.security.JwtService;
import com.example.userservice.security.UserHolder;
import com.example.userservice.service.user.api.IUserAuthenticationService;
import com.example.userservice.utils.exceptions.SingleErrorResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserAuthenticationService implements IUserAuthenticationService {

    private IUserRepository repository;
    private Converter<UserEntity, UserDTO> toDtoConverter;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;
    private UserHolder userHolder;


    public UserAuthenticationService(IUserRepository repository,
                                     Converter<UserEntity, UserDTO> toDtoConverter,
                                     AuthenticationManager authenticationManager,
                                     JwtService jwtService,
                                     UserHolder userHolder) {
        this.repository = repository;
        this.toDtoConverter = toDtoConverter;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userHolder = userHolder;
    }

    @Override
    public UserDTO getMyInfo() {

       UserEntity userInfo = (UserEntity) this.userHolder.getAuthentication().getPrincipal();
        return this.toDtoConverter.convert(userInfo);
    }

    @Override
    public AuthenticationResponse login(LoginDTO loginDTO) {

                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginDTO.getMail(),
                                loginDTO.getPassword()));

        return new AuthenticationResponse(jwtService.generateToken(
                this.repository.findByMail(loginDTO.getMail())));
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
