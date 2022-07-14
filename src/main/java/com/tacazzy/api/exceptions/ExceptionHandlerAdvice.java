package com.tacazzy.api.exceptions;

import com.tacazzy.api.exceptions.ex.DataBaseException;
import com.tacazzy.api.exceptions.ex.ResourceNotFoundException;
import org.hibernate.service.spi.Startable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        String error = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(value = DataBaseException.class)
    public ResponseEntity<StandardError> dataBaseException(DataBaseException ex, HttpServletRequest request) {
        String error = "Database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

}
