package com.kodilla.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TitleNotFoundException.class)
    public ResponseEntity<Object> handleTitleNotFoundException(TitleNotFoundException exception) {
        return new ResponseEntity<>("Title with given name doesn't exists in our library", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BookNotAvailableException.class)
    public ResponseEntity<Object> handleBookNotAvailableException(BookNotAvailableException exception) {
        return new ResponseEntity<>("Given book is not available now", HttpStatus.BAD_REQUEST);
    }
}
