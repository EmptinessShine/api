package com.taskflow.api.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<AppError>
    handleResourceNotFound(ResourceNotFoundException ex){
        AppError error = new AppError(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage()
        );
        log.error("Failed to find resouse: {}",ex.getMessage());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
