package com.example.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .cors().disable()
            .csrf().disable()
            .securityMatcher("/api/**")
            .authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/**").permitAll()
                    .requestMatchers("/api/v1/users").permitAll()
                    .requestMatchers("/api/v1/users/{uuid}").permitAll()
                    .requestMatchers("/api/v1/users/{uuid}/dt_update/{dt_update}").permitAll() //hasRole("ADMIN")
                    //.requestMatcher("/**").hasRole("ADMIN")
                    .requestMatchers("/api/v1/users/registration").permitAll()
                    .requestMatchers("/api/v1/users/verification").permitAll()
                    .requestMatchers("/api/v1/users/login").permitAll()
                    .requestMatchers("/api/v1/users/me").permitAll()
                    .anyRequest().permitAll() //anyRequest().authenticated()
            );
        return http.build();
    }
}
