package com.example.CaloriTrack.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

public class ExceptionValidatedRequestOrResponse extends BindException implements BindingResult {

    public ExceptionValidatedRequestOrResponse(BindingResult  message) {
        super(message);
    }
}