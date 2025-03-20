package com.example.CaloriTrack.repository;

import com.example.CaloriTrack.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {

}