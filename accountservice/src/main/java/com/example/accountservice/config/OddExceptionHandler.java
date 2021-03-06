package com.example.accountservice.config;

import com.example.accountservice.OddException;
import com.example.accountservice.model.ErrorStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class OddExceptionHandler {

    @ExceptionHandler({ OddException.class })
    public ResponseEntity<ErrorStatus> handleOddException(final Exception e, final WebRequest request) {
        ErrorStatus errorStatus = new ErrorStatus();
        errorStatus.setCode("999999");
        errorStatus.setMessage("General Error");

        return ResponseEntity.status(400).body(errorStatus);
    }
}
