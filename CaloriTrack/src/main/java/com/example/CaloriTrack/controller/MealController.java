package com.example.CaloriTrack.controller;

import com.example.CaloriTrack.annotation.CustomControllerHandler;
import com.example.CaloriTrack.dto.request.meal.MealDTO;
import com.example.CaloriTrack.exception.ExceptionValidatedRequestOrResponse;
import com.example.CaloriTrack.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/meals")
@RequiredArgsConstructor
@CustomControllerHandler
public class MealController {

    private final MealService mealService;

    @PostMapping
    public ResponseEntity<?> addMeal(@Validated @RequestBody MealDTO request, BindingResult bindingResult)
            throws ExceptionValidatedRequestOrResponse {
        if (bindingResult.hasErrors()) {
            throw new ExceptionValidatedRequestOrResponse(bindingResult);
        }
        return mealService.saveMeal(request);
    }
}