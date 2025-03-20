package com.example.CaloriTrack.controller;

import com.example.CaloriTrack.annotation.CustomControllerHandler;
import com.example.CaloriTrack.dto.request.dish.DishDTO;
import com.example.CaloriTrack.exception.ExceptionValidatedRequestOrResponse;
import com.example.CaloriTrack.service.DishService;
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
@RequestMapping("/v1/dish")
@RequiredArgsConstructor
@CustomControllerHandler
public class DishController {

    private final DishService dishService;

    @PostMapping()
    public ResponseEntity<?> saveDish(@Validated @RequestBody DishDTO request, BindingResult bindingResult) throws ExceptionValidatedRequestOrResponse {
        if (bindingResult.hasErrors()) {
            throw new ExceptionValidatedRequestOrResponse(bindingResult);
        }
        dishService.saveDish(request);
        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }
}