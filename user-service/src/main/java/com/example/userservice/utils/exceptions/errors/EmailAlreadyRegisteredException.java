package com.example.userservice.utils.exceptions.errors;

import com.example.userservice.utils.exceptions.RequestException;

public class EmailAlreadyRegisteredException extends RequestException {

    public EmailAlreadyRegisteredException() {
    }

    @Override
    public String getCode() {
        return "102";
    }

    @Override
    public String getMessage() {
        return "Email is already registered";
    }



}
