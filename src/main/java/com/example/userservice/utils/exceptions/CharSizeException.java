package com.example.userservice.utils.exceptions;

public class CharSizeException extends RequestException{
    private final String paramName;

    public CharSizeException(String paramName) {
        this.paramName = paramName;
    }
    @Override
    public String getCode() {
        return "03";
    }

    @Override
    public String getMessage() {
        return "Ooops, required parameter "+ paramName + " is too short or too long";
    }
}
