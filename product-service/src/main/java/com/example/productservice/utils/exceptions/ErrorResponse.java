package com.example.productservice.utils.exceptions;

public class ErrorResponse {
    private String logref;
    private String message;

    public ErrorResponse(){}

    public ErrorResponse(String message)
    {
        super();
        this.message = message;
    }

    public String getLogref() {
        return logref;
    }

    public void setLogref(String logref) {
        this.logref = logref;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
