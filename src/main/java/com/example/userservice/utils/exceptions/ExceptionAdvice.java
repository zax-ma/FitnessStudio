package com.example.userservice.utils.exceptions;

import com.example.userservice.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

/*    @ResponseBody
    @ExceptionHandler({CharSizeException.class,
            EmailPatternException.class, RequiredParameterIsEmptyException.class,
            RoleParamsException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorDTO requestParameterExceptionHandler(RequestException ex) {


       return ErrorDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .build();

    }
    */

}
