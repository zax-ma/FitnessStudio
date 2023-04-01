package com.example.userservice.utils.exceptions.errors;

public class MailAlreadyExistException extends RuntimeException {

    private String message;
    public MailAlreadyExistException(String msg) {
        super(msg);
        this.message = msg;
    }

    public String getCode() {
        return "01";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

