package com.example.CaloriTrack.mappers;

import com.example.CaloriTrack.dto.request.dish.DishDTO;
import com.example.CaloriTrack.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DishMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mealDishes", ignore = true)
    Dish toEntity(DishDTO dto);

    DishDTO toDto(Dish dish);
}