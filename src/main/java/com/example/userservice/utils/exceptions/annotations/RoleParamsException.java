package com.example.userservice.utils.exceptions.annotations;

import com.example.userservice.utils.exceptions.RequestException;

public class RoleParamsException extends RequestException {

    private final String paramName;

    public RoleParamsException(String paramName) {
        this.paramName = paramName;
    }
    @Override
    public String getCode() {
        return "06";
    }

    @Override
    public String getMessage() {
        return "Role "+ paramName + " is invalid";
    }

}
