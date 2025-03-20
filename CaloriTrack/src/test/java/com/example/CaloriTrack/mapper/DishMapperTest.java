package com.example.CaloriTrack.mapper;

import com.example.CaloriTrack.dto.request.dish.DishDTO;
import com.example.CaloriTrack.mappers.DishMapper;
import com.example.CaloriTrack.model.Dish;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


class DishMapperTest {

    private final DishMapper dishMapper = Mappers.getMapper(DishMapper.class);

    @Test
    void testToEntity() {
        DishDTO dishDTO = new DishDTO();
        dishDTO.setName("Полено");
        dishDTO.setCalories(3547);
        dishDTO.setProteins(268.5);
        dishDTO.setFats(25.8756);
        dishDTO.setCarbs(-2.0);

        Dish dish = dishMapper.toEntity(dishDTO);

        assertNotNull(dish);
        assertNull(dish.getId());
        assertEquals(dishDTO.getName(), dish.getName());
        assertEquals(dishDTO.getCalories(), dish.getCalories());
        assertEquals(dishDTO.getProteins(), dish.getProteins());
        assertEquals(dishDTO.getFats(), dish.getFats());
        assertEquals(dishDTO.getCarbs(), dish.getCarbs());

        assertNull(dish.getMealDishes());
    }

    @Test
    void testToDto() {
        Dish dish = new Dish();
        dish.setId(1L);
        dish.setName("Еда");
        dish.setCalories(140);
        dish.setProteins(26.0);
        dish.setFats(1.0);
        dish.setCarbs(407.0);

        DishDTO dishDTO = dishMapper.toDto(dish);

        assertNotNull(dishDTO);
        assertEquals(dish.getName(), dishDTO.getName());
        assertEquals(dish.getCalories(), dishDTO.getCalories());
        assertEquals(dish.getProteins(), dishDTO.getProteins());
        assertEquals(dish.getFats(), dishDTO.getFats());
        assertEquals(dish.getCarbs(), dishDTO.getCarbs());
    }
}