package com.example.userservice.utils.exceptions;

public abstract class RequestException extends RuntimeException{


    public abstract String getCode();

    @Override
    public abstract String getMessage();
}
