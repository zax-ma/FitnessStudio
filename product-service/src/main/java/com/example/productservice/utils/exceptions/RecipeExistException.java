package com.example.productservice.utils.exceptions;

public class RecipeExistException extends RuntimeException {

    private String message;
    public RecipeExistException(String msg) {
        super(msg);
        this.message = msg;
    }

    public String getCode() {
        return "21";
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}