package com.example.userservice.security.jwt.api;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;

public interface IJwtTokenProvider {

    Authentication getAuthentication(String token);

    String getUserMail(String token);

    String getUserRole(String token);

    String getUserId(String token);

    String resolveToken(HttpServletRequest req);

    boolean validateToken(String token);
}
