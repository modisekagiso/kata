package com.investec.kata.controller;

import com.investec.kata.exceptions.ClientValidationException;
import com.investec.kata.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class ClientControllerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClientValidationException.class)
    private ErrorResponse handleValidationException(RuntimeException e) {
        return new ErrorResponse(e.getMessage(), LocalDateTime.now());
    }
}
