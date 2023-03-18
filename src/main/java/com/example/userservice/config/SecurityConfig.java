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
            .antMatcher("/api/**")
            .authorizeHttpRequests((authz) -> authz
                    .antMatchers("/**").permitAll()
                    .antMatchers("/api/v1/users").permitAll()
                    .antMatchers("/api/v1/users/{uuid}").permitAll()
                    .antMatchers("/api/v1/users/{uuid}/dt_update/{dt_update}").permitAll() //hasRole("ADMIN")
                    //.requestMatcher("/**").hasRole("ADMIN")
                    .antMatchers("/api/v1/users/registration").permitAll()
                    .antMatchers("/api/v1/users/verification").permitAll()
                    .antMatchers("/api/v1/users/login").permitAll()
                    .antMatchers("/api/v1/users/me").permitAll()
                    .anyRequest().permitAll() //anyRequest().authenticated()
            );
        return http.build();
    }
}
