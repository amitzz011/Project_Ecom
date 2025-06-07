package com.batchten.ecom.Advice;

import com.batchten.ecom.Exception.ProductIsNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductIsNotFound.class)
    public ResponseEntity<ErrorDetails> handleProductException(ProductIsNotFound ex) {
        ErrorDetails error = new ErrorDetails(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception ex) {
        ErrorDetails error = new ErrorDetails(ex.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
