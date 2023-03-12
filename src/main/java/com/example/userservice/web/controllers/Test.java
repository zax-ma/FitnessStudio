package com.example.userservice.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    private static final Logger LOGGER = LoggerFactory.getLogger(Test.class);
    @GetMapping(value = "/welcome")
    public ResponseEntity welcomeEndpoint() {
        LOGGER.info("Welcome to test page! Everything started ok");
        return ResponseEntity.ok("Welcome to test page! Everything started ok");


    }
}
