package com.example.productservice.utils.exceptions;

public abstract class RequestException extends RuntimeException{


    public abstract String getCode();

    @Override
    public abstract String getMessage();
}
