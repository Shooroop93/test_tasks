package com.example.CaloriTrack.service;

import com.example.CaloriTrack.constants.Formulas;
import com.example.CaloriTrack.model.DailyCalories;
import com.example.CaloriTrack.model.User;
import com.example.CaloriTrack.utils.CalculateCalories;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CaloriesService {

    public List<DailyCalories> calculateDailyCalories(User user) {
        List<DailyCalories> dailyCalories = new ArrayList<>();

        for (Formulas formula : Formulas.values()) {
            double calculatedCalories = switch (formula) {
                case MIFFLIN ->
                        CalculateCalories.calculateBMRMifflin(user.getWeight(), user.getHeight(), user.getAge(), user.getGender());
            };
            dailyCalories.add(new DailyCalories(calculatedCalories, formula, user));
        }
        return dailyCalories;
    }
}