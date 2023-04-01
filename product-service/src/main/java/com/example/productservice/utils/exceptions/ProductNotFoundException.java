package com.example.productservice.utils.exceptions;

public class ProductNotFoundException extends RuntimeException {

    private String message;
    public ProductNotFoundException(String msg) {
        super(msg);
        this.message = msg;
    }

    public String getCode() {
        return "22";
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}