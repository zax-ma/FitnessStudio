package com.example.userservice.security;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.EUserRole;
import com.example.userservice.security.jwt.JwtUser;
import com.example.userservice.security.jwt.JwtUserFactory;
import com.example.userservice.service.user.api.IUserAuthenticationService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private IUserAuthenticationService userService;

    private Converter<UserEntity, EUserRole> roleconverter;

    public JwtUserDetailsService(IUserAuthenticationService userService,
                                 Converter<UserEntity, EUserRole> roleconverter) {
        this.userService = userService;
        this.roleconverter = roleconverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByMail(username);

        if(user == null){
            throw new UsernameNotFoundException("User with mail " + username + " not found");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);

        return jwtUser;
    }
}
