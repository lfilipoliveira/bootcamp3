package com.project.bootcamp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(BussinessException.class)
    protected ResponseEntity<ExceptionsResponse> handleSecurity(BussinessException e) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new ExceptionsResponse(e.getMessage()));
    }

    @ExceptionHandler(NotFoundExceptions.class)
    protected ResponseEntity<ExceptionsResponse> handleSecurity(NotFoundExceptions e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionsResponse(e.getMessage()));
    }
    
}
