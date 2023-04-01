package com.example.userservice.utils.exceptions.errors;

public class UserNotFoundException extends RuntimeException {

    private String message;

    public UserNotFoundException(String msg) {

        super(msg);
        this.message = msg;
    }

    public String getCode() {
        return "05";
    }
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

