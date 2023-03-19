package com.example.userservice.security.jwt;


import com.example.userservice.dao.entity.UserEntity;
import com.example.userservice.dto.UserRole;
import com.example.userservice.security.jwt.api.IJwtTokenProvider;
import io.jsonwebtoken.*;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtTokenProvider{

    @Value("${jwt.token.secret}")
    private String secret;
    @Value("${jwt.token.expired}")
    private Long expiryMilliseconds;
    private UserDetailsService userDetailsService;
    private PasswordEncoder passwordEncoder;

    public JwtTokenProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    protected void init() {secret = Base64.getEncoder().encodeToString(secret.getBytes(StandardCharsets.UTF_8));}

    public String createToken(UserEntity user) {
        Claims claims = Jwts.claims().setSubject(user.getMail());
        claims.put("userId", user.getUuid() + "");
        claims.put("role", user.getRole());

        Date creationTime = new Date();
        Date expiryTime = new Date(creationTime.getTime() + expiryMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(creationTime)
                .setExpiration(expiryTime)
                .signWith(SignatureAlgorithm.ES256, secret)
                .compact();
    }

/*    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if(true){

        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }*/

/*    public Authentication getAuthentication(String token){
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUserMail(token));
        return new UsernamePasswordAuthenticationToken(userDetails,"", userDetails.getAuthorities());
    }*/

    public String getUserMail(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public String getUserRole(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("userId").toString();
    }

    public String getUserId(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().get("role").toString();
    }

    public String resolveToken(HttpServletRequest req){
        String bearerToken = req.getHeader("Authorisation");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    public boolean validateToken(String token){
        try {
            Jws<Claims> claimsJwc = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            if(claimsJwc.getBody().getExpiration().before(new Date())){
                return false;
            }
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthenticationException("JWT token is expirred or invalid");
        }
    }


}
