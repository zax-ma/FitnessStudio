package com.example.userservice.config;

import com.example.userservice.security.jwt.JwtTokenProvider;
import com.example.userservice.security.jwt.api.IJwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    public IJwtTokenProvider jwtTokenProvider;

/*    private final JwtTokenProvider jwtTokenProvider;
    @Autowired
    public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }*/


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
            )
            .httpBasic(Customizer.withDefaults())
            .authenticationManager(new AuthenticationManager() {
                @Override
                public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                    return null;
                }
            });
        return http.build();
    }
}
