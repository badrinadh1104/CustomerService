package com.customer.exceptions;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
//        return ResponseEntity.badRequest().body("Invalid ID: " + ex.getValue());
//    }
//}
