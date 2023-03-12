package com.example.userservice.dto;

public class ErrorDTO {
    private String code;

    private String message;


    public ErrorDTO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }


}
