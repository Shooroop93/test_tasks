package com.example.CaloriTrack.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Errors {

    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("error_message")
    private List<String> errors;

    public void addError(String error) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(error);
    }

    public Errors(int statusCode, String error) {
        this.statusCode = statusCode;
        if (errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(error);
    }
}