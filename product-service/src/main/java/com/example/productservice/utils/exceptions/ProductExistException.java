package com.example.productservice.utils.exceptions;

public class ProductExistException extends RuntimeException {

    private String message;
    public ProductExistException(String msg) {
        super(msg);
        this.message = msg;
    }

    public String getCode() {
        return "23";
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}