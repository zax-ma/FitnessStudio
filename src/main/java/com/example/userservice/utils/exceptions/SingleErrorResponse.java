package com.example.userservice.utils.exceptions;

import java.util.ArrayList;
import java.util.List;

public class SingleErrorResponse extends RequestException{

    private List<Error> errors = new ArrayList<>();

    public SingleErrorResponse(String message) {

        this.errors.add(new Error(message));
    }

    public List<Error> getErrors() {
        return errors;
    }


    @Override
    public String getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return getErrors().toString();
    }
}
