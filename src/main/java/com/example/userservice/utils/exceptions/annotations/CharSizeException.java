package com.example.userservice.utils.exceptions.annotations;

import com.example.userservice.utils.exceptions.RequestException;

public class CharSizeException extends RequestException {
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
        return "Ooops, required parameter "+ paramName + " is shorter then 3 or longer then 16";
    }
}
