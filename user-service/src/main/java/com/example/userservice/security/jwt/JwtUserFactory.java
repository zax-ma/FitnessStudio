package com.example.userservice.security.jwt;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.UserStatus;
import com.example.userservice.utils.convertors.RoleConverter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory() {
    }

    public static JwtUser create(UserEntity user){
        RoleConverter converter = new RoleConverter();
        return new JwtUser(
                user.getUuid(),
                user.getMail(),
                user.getFio(),
                user.getPassword(),
                user.getStatus().equals(UserStatus.ACTIVATED),
                user.getDt_update(),
                null
 //               mapToGrantedAuthorities(new ArrayList<>((Collection) converter.convert(user)))
        );
    }

/*    private static List<GrantedAuthority> mapToGrantedAuthorities(List<RoleEntity> userRoles){
        return userRoles.stream()
                .map(role ->
                     new SimpleGrantedAuthority(role.getName())
                )
                .collect(Collectors.toList());
    }*/

}
