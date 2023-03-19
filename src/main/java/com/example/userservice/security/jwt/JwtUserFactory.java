package com.example.userservice.security.jwt;

import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.EUserRole;
import com.example.userservice.dto.UserRole;
import com.example.userservice.dto.UserStatus;
import com.example.userservice.utils.convertors.RoleConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public final class JwtUserFactory {


/*    public static void main(String[] args) {
        UUID hz = UUID.randomUUID();
        LocalDateTime he = LocalDateTime.now();

        UserEntity test = new UserEntity(hz,
                "matrikary@gmail.com", "kkkk", "fffff",
                UserRole.ADMIN,
                UserStatus.ACTIVATED,
                he,
                he
                );

        JwtUserFactory userFactory = new JwtUserFactory();

        RoleConverter conv = new RoleConverter();
        conv.convert(test);
        System.out.println("hello" + conv.convert(test));



    }*/

    public JwtUserFactory() {
    }

    public static JwtUser create(UserEntity user){
        return new JwtUser(
                user.getUuid(),
                user.getMail(),
                user.getFio(),
                user.getPassword(),
                converter.convert(user),
                user.getStatus().equals(UserStatus.ACTIVATED),
                user.getDt_update(),
                null
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<UserRole> userRoles){
        return userRoles.stream()
                .map(role ->
                     new SimpleGrantedAuthority(converter.convert(user))
                )
                .collect(Collectors.toList());
    }

}
