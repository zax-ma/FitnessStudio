package com.example.userservice.utils.exceptions.errors;

public class CodeExpiredException extends RuntimeException{
    private String message;
    public CodeExpiredException(String msg) {
        super(msg);
        this.message = msg;
    }

    public String getCode() {
        return "06";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
