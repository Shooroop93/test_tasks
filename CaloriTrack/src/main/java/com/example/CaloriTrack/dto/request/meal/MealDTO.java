package com.example.CaloriTrack.dto.request.meal;

import com.example.CaloriTrack.dto.request.dish.DishDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class MealDTO {

    @JsonProperty("user_id")
    @NotNull
    private Long userId;
    @NotNull
    @NotEmpty
    private List<DishDTO> dishes;
}