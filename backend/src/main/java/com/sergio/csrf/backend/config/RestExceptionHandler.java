package com.sergio.csrf.backend.config;

import com.sergio.csrf.backend.dtos.ErrorDto;
import com.sergio.csrf.backend.exceptions.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> handleAppException(AppException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new ErrorDto(ex.getMessage()));
    }
}
