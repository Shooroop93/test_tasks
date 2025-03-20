package com.example.CaloriTrack.advice;

import com.example.CaloriTrack.annotation.CustomControllerHandler;
import com.example.CaloriTrack.dto.request.CaloriTrackResponse;
import com.example.CaloriTrack.dto.request.Errors;
import com.example.CaloriTrack.exception.ExceptionValidatedRequestOrResponse;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Locale;

@ControllerAdvice(annotations = {CustomControllerHandler.class})
@RequiredArgsConstructor
public class ValidatedRequestOrResponseAdvice {


    @ExceptionHandler(ExceptionValidatedRequestOrResponse.class)
    public ResponseEntity<CaloriTrackResponse> handleValidateException(BindException exception, Locale locale) {

        CaloriTrackResponse response = new CaloriTrackResponse();

        List<String> errorMessages = exception.getFieldErrors().stream()
                .map(fieldError -> String.format("%s: %s", fieldError.getField(), fieldError.getDefaultMessage()))
                .toList();

        Errors errors = new Errors(HttpStatus.BAD_REQUEST.value(), errorMessages);
        response.addErrorList(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<CaloriTrackResponse> handleInvalidFormatException(InvalidFormatException exception) {
        CaloriTrackResponse response = new CaloriTrackResponse();
        List<String> errorMessages = exception.getPath().stream()
                .map(ref -> String.format("Некорректное значение '%s'",
                        exception.getValue()))
                .toList();

        Errors errors = new Errors(HttpStatus.BAD_REQUEST.value(), errorMessages);
        response.addErrorList(errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}