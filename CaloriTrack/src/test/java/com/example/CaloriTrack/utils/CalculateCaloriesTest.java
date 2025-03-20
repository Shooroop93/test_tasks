package com.example.CaloriTrack.utils;

import com.example.CaloriTrack.constants.Gender;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculateCaloriesTest {

    @Test
    void testCalculateBMRMifflinForMale() {
        double weight = 80.0;
        double height = 180.0;
        int age = 30;
        Gender gender = Gender.MALE;

        double expectedBMR = 9.99 * weight + 6.25 * height - 5 * age + 5;
        double actualBMR = CalculateCalories.calculateBMRMifflin(weight, height, age, gender);

        assertEquals(expectedBMR, actualBMR);
    }

    @Test
    void testCalculateBMRMifflinForFemale() {
        double weight = 60.0;
        double height = 165.0;
        int age = 25;
        Gender gender = Gender.FEMALE;

        double expectedBMR = 9.99 * weight + 6.25 * height - 5 * age - 161;
        double actualBMR = CalculateCalories.calculateBMRMifflin(weight, height, age, gender);

        assertEquals(expectedBMR, actualBMR);
    }

    @Test
    void testCalculateBMRMifflinBoundaryValues() {
        double weight = 999999999999999999999999.0;
        double height = -999999999999999999999999.0;
        int age = 0;
        Gender gender = Gender.MALE;

        double expectedBMR = 9.99 * weight + 6.25 * height - 5 * age + 5;
        double actualBMR = CalculateCalories.calculateBMRMifflin(weight, height, age, gender);

        assertEquals(expectedBMR, actualBMR);

        gender = Gender.FEMALE;
        expectedBMR = 9.99 * weight + 6.25 * height - 5 * age - 161;
        actualBMR = CalculateCalories.calculateBMRMifflin(weight, height, age, gender);

        assertEquals(expectedBMR, actualBMR);
    }
}