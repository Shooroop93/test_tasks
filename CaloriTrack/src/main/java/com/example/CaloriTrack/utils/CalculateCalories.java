package com.example.CaloriTrack.utils;

import com.example.CaloriTrack.constants.Gender;

public class CalculateCalories {

    public static double calculateBMRMifflin(double weight, double height, int age, Gender gender) {
        return switch (gender) {
            case MALE -> 9.99 * weight + 6.25 * height - 5 * age + 5;
            case FEMALE -> 9.99 * weight + 6.25 * height - 5 * age - 161;
        };
    }
}