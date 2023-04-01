package com.example.userservice.utils.exceptions;


import com.example.userservice.utils.exceptions.annotations.CharSizeException;
import com.example.userservice.utils.exceptions.annotations.EmailPatternException;
import com.example.userservice.utils.exceptions.annotations.RequiredParameterIsEmptyException;
import com.example.userservice.utils.exceptions.annotations.RoleParamsException;
import com.example.userservice.utils.exceptions.errors.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class ExceptionAdviceController extends ResponseEntityExceptionHandler {


    @ExceptionHandler({CharSizeException.class,
            EmailPatternException.class, RequiredParameterIsEmptyException.class,
            RoleParamsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse requestParameterExceptionHandler(RequestException ex)
    {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        errorResponse.setLogref("error: " + ex.getCode());
        return errorResponse;

    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleUserNotFound(UserNotFoundException ex)

    {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage());
                errorResponse.setLogref("error: " + ex.getCode());
        return errorResponse;
    }

    @ExceptionHandler(value
            = UserAlreadyUpdatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleUserAlreadyUpdated(UserAlreadyUpdatedException ex)

    {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage());
                errorResponse.setLogref("error: " + ex.getCode());
        return errorResponse;
    }


    @ExceptionHandler(value
            = MailNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleMailNotFound(MailNotFoundException ex)

    {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage());
                errorResponse.setLogref("error: " + ex.getCode());
        return errorResponse;
    }


    @ExceptionHandler(value
            = MailAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleMailAlreadyExist(MailAlreadyExistException ex)

    {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.getMessage());
                errorResponse.setLogref("error: " + ex.getCode());
            return errorResponse;
    }

}
