package com.example.CaloriTrack.repository;

import com.example.CaloriTrack.model.DailyCalories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyCaloriesRepository extends JpaRepository<DailyCalories, Long> {

}