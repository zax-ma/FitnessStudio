package com.example.userservice.security;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.service.user.api.IUserAdminService;
import com.example.userservice.service.user.api.IUserAuthenticationService;
import com.example.userservice.service.user.api.IUserRegistrationService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private IUserAuthenticationService userService;

    public JwtUserDetailsService(IUserAuthenticationService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByMail(username);

        if(user == null){
            throw new UsernameNotFoundException("User with mail " + username + " not found");
        }

        return null;
    }
}
