package com.example.productservice.security;

import com.example.userservice.security.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal( @NonNull HttpServletRequest request,
                                     @NonNull HttpServletResponse response,
                                     @NonNull FilterChain filterChain)
            throws ServletException, IOException {

        final String authenticationHeader = request.getHeader("Authorization");
        final String jwt;
        final String userMail;

        if(authenticationHeader == null || !authenticationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request, response);
            return;
        }
        jwt = authenticationHeader.substring(7);
        userMail = jwtService.extractUsername(jwt);
        if(userMail != null
                && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(userMail);
            if(jwtService.isTokenValid(jwt, userDetails)){
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities());

                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
        }
        filterChain.doFilter(request, response);
    }
}

