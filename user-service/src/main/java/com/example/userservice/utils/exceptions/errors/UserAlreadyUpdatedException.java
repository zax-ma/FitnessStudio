package com.example.userservice.utils.exceptions.errors;

public class UserAlreadyUpdatedException extends RuntimeException {

    private String message;
    public UserAlreadyUpdatedException(String msg) {
        super(msg);
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
