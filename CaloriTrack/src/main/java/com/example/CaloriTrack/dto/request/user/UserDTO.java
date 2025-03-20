package com.example.CaloriTrack.dto.request.user;

import com.example.CaloriTrack.constants.Gender;
import com.example.CaloriTrack.constants.Goal;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    @Email
    private String email;
    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;
    @NotNull
    private Double weight;
    @NotNull
    private Double height;
    @NotNull
    private Goal goal;
    private Gender gender;
}