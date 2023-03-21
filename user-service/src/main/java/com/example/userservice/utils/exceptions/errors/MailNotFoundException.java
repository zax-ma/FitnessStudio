package com.example.userservice.utils.exceptions.errors;

public class MailNotFoundException extends RuntimeException {

    private String message;
    public MailNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

