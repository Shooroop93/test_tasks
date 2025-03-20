package com.example.CaloriTrack.dto.request.dish;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class DishDTO {

    private Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Min(1)
    private Integer calories;

    @NotNull
    @Positive
    private Double proteins;

    @NotNull
    @Positive
    private Double fats;

    @NotNull
    @Positive
    private Double carbs;
}