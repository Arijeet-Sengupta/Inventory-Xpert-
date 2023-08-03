package com.dbtest.dbtest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandlers {

    @org.springframework.web.bind.annotation.ExceptionHandler
            (Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        // Handle the exception and return an appropriat
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request: " + ex.getMessage());
    }
}