package com.example.CaloriTrack.repository;

import com.example.CaloriTrack.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {

}