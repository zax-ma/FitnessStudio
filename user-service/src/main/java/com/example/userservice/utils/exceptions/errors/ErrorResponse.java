package com.example.userservice.utils.exceptions.errors;

public class ErrorResponse {
    private String statusCode;
    private String message;

    public ErrorResponse(){}

    public ErrorResponse(String statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }

    public ErrorResponse(String message)
    {
        super();
        this.message = message;
    }

}
