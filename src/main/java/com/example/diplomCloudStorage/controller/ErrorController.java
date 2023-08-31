package com.example.diplomCloudStorage.controller;

import com.example.diplomCloudStorage.dto.response.Error;
import com.example.diplomCloudStorage.exceptions.AuthorizationException;
import com.example.diplomCloudStorage.exceptions.BadCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class ErrorController {
    private final Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {BindException.class, BadCredentialsException.class, IOException.class})
    Error handleBindException(Exception e) {
        logger.error(e.getMessage());
        return new Error(e.getMessage(), -1);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizationException.class)
    Error handleAuthorizationException(AuthorizationException e) {
        logger.error(e.getMessage());
        return new Error(e.getMessage(), -1);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    Error handleRuntimeException(RuntimeException e) {
        logger.error(e.getMessage());
        return new Error(e.getMessage(), -1);
    }
}