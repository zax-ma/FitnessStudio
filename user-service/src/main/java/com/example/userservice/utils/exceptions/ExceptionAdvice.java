package com.example.userservice.utils.exceptions;

import com.example.userservice.dto.ErrorDTO;
import com.example.userservice.utils.exceptions.annotations.CharSizeException;
import com.example.userservice.utils.exceptions.annotations.EmailPatternException;
import com.example.userservice.utils.exceptions.annotations.RequiredParameterIsEmptyException;
import com.example.userservice.utils.exceptions.annotations.RoleParamsException;
import com.example.userservice.utils.exceptions.errors.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler({CharSizeException.class,
            EmailPatternException.class, RequiredParameterIsEmptyException.class,
            RoleParamsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorDTO requestParameterExceptionHandler(RequestException ex) {
     return new ErrorDTO(ex.getCode(), ex.getMessage());

    }
    @ExceptionHandler(value
            = UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleUserNotFound(UserNotFoundException ex)

    {
        return new ErrorResponse("error", ex.getMessage());
    }

    @ExceptionHandler(value
            = UserAlreadyUpdatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleUserAlreadyUpdated(UserAlreadyUpdatedException ex)

    {
        return new ErrorResponse("error", ex.getMessage());
    }


    @ExceptionHandler(value
            = MailNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleMailNotFound(MailNotFoundException ex)

    {
        return new ErrorResponse("error", ex.getMessage());
    }


/*    @ExceptionHandler(value
            = MailAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse handleMailAlreadyExist(MailAlreadyExistException ex)

    {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }*/


    @ExceptionHandler(value
            = MailAlreadyExistException.class)
    public ResponseEntity<List<ErrorResponse>> handleMailAlreadyExist(MailAlreadyExistException ex)

    {
        ErrorResponse errorResponse = new ErrorResponse("error",
                ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(List.of(errorResponse));
    }


}
