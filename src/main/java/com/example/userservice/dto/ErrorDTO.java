package com.example.userservice.dto;

public class ErrorDTO {
    private String code;

    private String message;


    public ErrorDTO() {
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorDTO.Builder create() {
        return new ErrorDTO().new Builder();
    }
    public class Builder {
        public Builder() {
        }

        public ErrorDTO.Builder setCode(String code) {
            ErrorDTO.this.code = code;
            return this;
        }

        public ErrorDTO.Builder setMessage(String message) {
            ErrorDTO.this.message = message;
            return this;
        }


        public ErrorDTO build() {
            return ErrorDTO.this;
        }
    }

}
