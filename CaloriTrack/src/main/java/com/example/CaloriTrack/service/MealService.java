package com.example.CaloriTrack.service;

import com.example.CaloriTrack.dto.request.CaloriTrackResponse;
import com.example.CaloriTrack.dto.request.Errors;
import com.example.CaloriTrack.dto.request.dish.DishDTO;
import com.example.CaloriTrack.dto.request.meal.MealDTO;
import com.example.CaloriTrack.model.Dish;
import com.example.CaloriTrack.model.Meal;
import com.example.CaloriTrack.model.MealDish;
import com.example.CaloriTrack.model.User;
import com.example.CaloriTrack.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class MealService {

    private final UserService userService;
    private final DishService dishService;
    private final MealRepository mealRepository;

    public ResponseEntity<?> saveMeal(MealDTO request) {
        CaloriTrackResponse response = new CaloriTrackResponse();

        Optional<User> userOptional = userService.findById(request.getUserId());
        if (userOptional.isEmpty()) {
            response.addErrorList(new Errors(HttpStatus.NOT_FOUND.value(),
                    format("Пользователь с id: %s не найден", request.getUserId())));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        User user = userOptional.get();

        Meal meal = new Meal(LocalDate.now(), user);
        List<MealDish> mealDishes = new ArrayList<>();

        for (DishDTO dishEntry : request.getDishes()) {
            Optional<Dish> dishOptional = dishService.findById(dishEntry.getId());
            if (dishOptional.isEmpty()) {
                response.addErrorList(new Errors(HttpStatus.NOT_FOUND.value(),
                        format("Блюдо с id: %s не найдено", dishEntry.getId())));
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
            Dish dish = dishOptional.get();

            MealDish mealDish = new MealDish();
            mealDish.setMeal(meal);
            mealDish.setDish(dish);
            mealDish.setPortion(1);

            mealDishes.add(mealDish);
        }

        meal.setMealDishes(mealDishes);
        mealRepository.save(meal);

        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }
}