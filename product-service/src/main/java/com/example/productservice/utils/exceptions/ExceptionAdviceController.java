package com.example.productservice.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionAdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleUserNotFound(ProductExistException ex)

    {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage());
        errorResponse.setLogref("error: " + ex.getCode());
        return errorResponse;
    }

    @ExceptionHandler(value
            = ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleProductNotFound(ProductNotFoundException ex)

    {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage());
        errorResponse.setLogref("error: " + ex.getCode());
        return errorResponse;
    }


    @ExceptionHandler(value
            = RecipeExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleMailNotFound(RecipeExistException ex)

    {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage());
        errorResponse.setLogref("error: " + ex.getCode());
        return errorResponse;
    }


    @ExceptionHandler(value
            = RecipeNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleMailAlreadyExist(RecipeNotFoundException ex)

    {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage());
        errorResponse.setLogref("error: " + ex.getCode());
        return errorResponse;
    }

}
