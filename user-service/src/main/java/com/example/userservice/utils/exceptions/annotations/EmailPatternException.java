package com.example.userservice.utils.exceptions.annotations;

import com.example.userservice.utils.exceptions.RequestException;

public class EmailPatternException extends RequestException {
    private final String paramName;

    public EmailPatternException(String paramName) {
        this.paramName = paramName;
    }

    @Override
    public String getCode() {
        return "12";
    }

    @Override
    public String getMessage() {
        return "Ooops, " + this.paramName + " is not an e-mail";
    }
}
