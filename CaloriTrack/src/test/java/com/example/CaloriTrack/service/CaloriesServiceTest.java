package com.example.CaloriTrack.service;

import com.example.CaloriTrack.constants.Formulas;
import com.example.CaloriTrack.constants.Gender;
import com.example.CaloriTrack.model.DailyCalories;
import com.example.CaloriTrack.model.User;
import com.example.CaloriTrack.utils.CalculateCalories;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CaloriesServiceTest {

    @InjectMocks
    private CaloriesService caloriesService;

    @Test
    void testCalculateDailyCalories() {
        User user;
        user = new User();
        user.setWeight(80.0);
        user.setHeight(180.0);
        user.setAge(30);
        user.setGender(Gender.MALE);

        double expectedCalories = CalculateCalories.calculateBMRMifflin(user.getWeight(), user.getHeight(), user.getAge(), user.getGender());

        List<DailyCalories> dailyCaloriesList = caloriesService.calculateDailyCalories(user);

        assertNotNull(dailyCaloriesList);
        assertFalse(dailyCaloriesList.isEmpty());

        assertEquals(Formulas.values().length, dailyCaloriesList.size());

        DailyCalories firstEntry = dailyCaloriesList.getFirst();
        assertEquals(Formulas.MIFFLIN, firstEntry.getFormula());
        assertEquals(expectedCalories, firstEntry.getCalories());
        assertEquals(user, firstEntry.getUser());
    }
}