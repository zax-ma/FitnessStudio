package com.example.userservice.web.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping(value = "/welcome")
    public ResponseEntity welcomeEndpoint() {
        return ResponseEntity.ok("Welcome to Baeldung Spring Boot Demo!");
    }
}
