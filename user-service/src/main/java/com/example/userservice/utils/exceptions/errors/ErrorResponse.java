package com.example.userservice.utils.exceptions.errors;

import java.util.function.Function;

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
