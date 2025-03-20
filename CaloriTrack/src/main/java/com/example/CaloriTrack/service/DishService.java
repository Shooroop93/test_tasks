package com.example.CaloriTrack.service;

import com.example.CaloriTrack.dto.request.dish.DishDTO;
import com.example.CaloriTrack.mappers.DishMapper;
import com.example.CaloriTrack.model.Dish;
import com.example.CaloriTrack.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void saveDish(DishDTO request) {

        Dish dish = dishMapper.toEntity(request);
        dishRepository.save(dish);
    }

    @Transactional(readOnly = true)
    public Optional<Dish> findById(Long id) {
        return dishRepository.findById(id);
    }
}