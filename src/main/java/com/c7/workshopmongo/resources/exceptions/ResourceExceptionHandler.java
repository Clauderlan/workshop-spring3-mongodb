package com.c7.workshopmongo.resources.exceptions;

import com.c7.workshopmongo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        int status = HttpStatus.NOT_FOUND.value();
        StandardError standardError = new StandardError(Instant.now(), status,"Not Found",e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }

}
