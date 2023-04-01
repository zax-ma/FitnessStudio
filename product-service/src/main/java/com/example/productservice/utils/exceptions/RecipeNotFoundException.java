package com.example.productservice.utils.exceptions;

public class RecipeNotFoundException extends RuntimeException {

    private String message;
    public RecipeNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

    public String getCode() {
        return "20";
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}